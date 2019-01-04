package sep.entity.resolver.asm.hibernate;

import org.objectweb.asm.*;
import sep.entity.struct.entity.Entity;
import sep.entity.struct.field.Field;
import sep.entity.struct.field.special.Id;
import sep.entity.struct.field.value.FieldValueGetter;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import static org.objectweb.asm.Opcodes.*;

public class HibernateEntityClassVisitor extends ClassVisitor {

    private String internalEntityName;

    private Entity<?> entity;
    private String tableName;
    private List<Field> fields = new ArrayList<Field>();
    private Supplier supplier;

    public HibernateEntityClassVisitor() {
        super(ASM4);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.internalEntityName = name;
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        //按@Table解析表名
        if (descriptor.equals("Ljavax/persistence/Table;")) {
            TableAnnotationVisitor tableAnnotationVisitor = new TableAnnotationVisitor();
            return tableAnnotationVisitor;
        }
        else return super.visitAnnotation(descriptor, visible);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        if (name.equals("<init>")) {
            EntitySuppierClassWriter entitySuppierClassWriter = new EntitySuppierClassWriter();
            entitySuppierClassWriter.visit(V1_8,
                    ACC_PUBLIC + ACC_SUPER,
                    "sep/entity/struct/EntitySupplier$" + tableName,
                    "Ljava/lang/Object;Ljava/util/function/Supplier<L" + internalEntityName +";>;",
                    //null,
                    "java/lang/Object",
                    new String[]{"java/util/function/Supplier"});
            MethodVisitor constructorVisitor = entitySuppierClassWriter.visitMethod(ACC_PUBLIC,
                    "<init>",
                    "()V",
                    null,
                    null);
            constructorVisitor.visitMaxs(1, 2);
            constructorVisitor.visitVarInsn(ALOAD, 0);
            constructorVisitor.visitMethodInsn(INVOKESPECIAL,
                    "java/lang/Object",
                    "<init>",
                    "()V",
                    false);
            constructorVisitor.visitInsn(RETURN);
            constructorVisitor.visitEnd();
            MethodVisitor getVisitor = entitySuppierClassWriter.visitMethod(ACC_PUBLIC,
                    "get",
                    //"()L"+internalEntityName+";",
                    "()Ljava/lang/Object;",
                    null,
                    null);
            getVisitor.visitMaxs(2, 2);
            getVisitor.visitTypeInsn(NEW, internalEntityName);
            getVisitor.visitInsn(DUP);
            getVisitor.visitMethodInsn(INVOKESPECIAL,
                    internalEntityName,
                    "<init>",
                    "()V",
                    false);
            getVisitor.visitInsn(ARETURN);
            getVisitor.visitEnd();
            entitySuppierClassWriter.visitEnd();
            byte[] b1 = entitySuppierClassWriter.toByteArray();
            Class newEntitySupplierClass = new ClassLoader().defineClass("sep.entity.struct.EntitySupplier$" + tableName, b1);
            try {
                supplier = (Supplier) newEntitySupplierClass.getConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (name.startsWith("get")) {
            try {
                GetterVisitor getterVisitor = new GetterVisitor(name, createFieldValueGetter(name, descriptor), createFieldValueSetter(name, descriptor), getFieldValueClass(descriptor));
                return getterVisitor;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return super.visitMethod(access, name, descriptor, signature, exceptions);
        } else {
            return super.visitMethod(access, name, descriptor, signature, exceptions);
        }
    }

    //Getter

    public String getTableName() {
        return tableName;
    }

    public List<Field> getFields() {
        return fields;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    private Class getFieldValueClass(String descriptor) {
        try {
            return Class.forName(descriptor.replaceFirst("\\(\\)L", "").replaceAll(";", "").replaceAll("/", "."));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private BiConsumer createFieldValueSetter(String name, String descriptor) throws Exception {
        String paramInternalName = descriptor.replaceFirst("\\(\\)L", "").replaceAll(";", "");
        FieldValueSetterClassWriter fieldValueSetterClassWriter = new FieldValueSetterClassWriter();
        fieldValueSetterClassWriter.visit(
                V1_8,
                ACC_PUBLIC + ACC_SUPER,
                "sep/entity/struct/field/value/FieldValueSetter$" + tableName + "$" + name.replaceFirst("get", "set"),
                null,
                "java/lang/Object",
                new String[] {"java/util/function/BiConsumer"}
        );
        //构造函数
        MethodVisitor constructorVisitor = fieldValueSetterClassWriter.visitMethod(ACC_PUBLIC,
                "<init>",
                "()V",
                null,
                null);
        constructorVisitor.visitMaxs(1, 2);
        constructorVisitor.visitVarInsn(ALOAD, 0);
        constructorVisitor.visitMethodInsn(INVOKESPECIAL,
                "java/lang/Object",
                "<init>",
                "()V",
                false);
        constructorVisitor.visitInsn(RETURN);
        constructorVisitor.visitEnd();
        //
        MethodVisitor acceptVisitor = fieldValueSetterClassWriter.visitMethod(ACC_PUBLIC,
                "accept",
                "(Ljava/lang/Object;Ljava/lang/Object;)V",
                null,
                null);
        acceptVisitor.visitMaxs(2, 3);
        acceptVisitor.visitCode();
        acceptVisitor.visitVarInsn(ALOAD, 2);
        Label label = new Label();
        acceptVisitor.visitJumpInsn(IFNONNULL, label);
        acceptVisitor.visitVarInsn(ALOAD, 1);
        acceptVisitor.visitTypeInsn(CHECKCAST, internalEntityName);
        acceptVisitor.visitInsn(ACONST_NULL);
        acceptVisitor.visitMethodInsn(INVOKEVIRTUAL,
                internalEntityName,
                name.replaceFirst("get", "set"),
                "(L" + paramInternalName + ";)V",
                false);
        Label end = new Label();
        acceptVisitor.visitJumpInsn(GOTO, end);
        acceptVisitor.visitLabel(label);
        acceptVisitor.visitFrame(F_SAME, 0, null, 0, null);
        acceptVisitor.visitVarInsn(ALOAD, 1);
        acceptVisitor.visitTypeInsn(CHECKCAST, internalEntityName);
        acceptVisitor.visitVarInsn(ALOAD, 2);
        acceptVisitor.visitTypeInsn(CHECKCAST, paramInternalName);
        acceptVisitor.visitMethodInsn(INVOKEVIRTUAL,
                internalEntityName,
                name.replaceFirst("get", "set"),
                "(L" + paramInternalName + ";)V",
                false);
        acceptVisitor.visitLabel(end);
        acceptVisitor.visitFrame(F_SAME, 0, null, 0, null);
        acceptVisitor.visitInsn(RETURN);
        acceptVisitor.visitEnd();
        fieldValueSetterClassWriter.visitEnd();
        byte[] b = fieldValueSetterClassWriter.toByteArray();
        Class newFieldValueSetterClass = new ClassLoader().defineClass("sep.entity.struct.field.value.FieldValueSetter$" + tableName + "$" + name.replaceFirst("get", "set"), b);
        BiConsumer biConsumer = (BiConsumer) newFieldValueSetterClass.getConstructor().newInstance();
        return biConsumer;
    }

    private FieldValueGetter createFieldValueGetter(String name, String descriptor) throws Exception {
        //创建FieldValueGetter的子类
        //类信息
        FieldValueGetterClassWriter fieldValueGetterClassWriter = new FieldValueGetterClassWriter();
        fieldValueGetterClassWriter.visit(V1_8,
                ACC_PUBLIC + ACC_SUPER,
                FieldValueGetter.class.getName().replaceAll("\\.", "/") + "$" + tableName + "$" + name,
                internalEntityName,
                FieldValueGetter.class.getName().replaceAll("\\.", "/"),
                null);
        //构造函数
        MethodVisitor constructorVisitor = fieldValueGetterClassWriter.visitMethod(ACC_PUBLIC,
                "<init>",
                "()V",
                null,
                null);
        constructorVisitor.visitMaxs(1, 2);
        constructorVisitor.visitVarInsn(ALOAD, 0);
        constructorVisitor.visitMethodInsn(INVOKESPECIAL,
                FieldValueGetter.class.getName().replaceAll("\\.", "/"),
                "<init>",
                "()V",
                false);
        constructorVisitor.visitInsn(RETURN);
        constructorVisitor.visitEnd();
        //子类getValue
        MethodVisitor getValueVisitor = fieldValueGetterClassWriter.visitMethod(ACC_PUBLIC,
                "getValue",
                "(Ljava/lang/Object;)Ljava/lang/Object;",
                null,
                null);
        getValueVisitor.visitMaxs(1, 2);
        getValueVisitor.visitVarInsn(ALOAD, 1);
        getValueVisitor.visitTypeInsn(CHECKCAST, internalEntityName);
        getValueVisitor.visitMethodInsn(INVOKEVIRTUAL,
                internalEntityName,
                name,
                descriptor,
                false);
        getValueVisitor.visitInsn(ARETURN);
        getValueVisitor.visitEnd();
        fieldValueGetterClassWriter.visitEnd();
        byte[] b = fieldValueGetterClassWriter.toByteArray();
        Class newFieldValueGetterClass = new ClassLoader().defineClass(FieldValueGetter.class.getName() + "$" + tableName + "$" + name, b);
        FieldValueGetter fieldValueGetter = (FieldValueGetter) newFieldValueGetterClass.getConstructor().newInstance();
        return fieldValueGetter;
    }


    //-----------------------------------
    //inner class
    //-----------------------------------

    class TableAnnotationVisitor extends AnnotationVisitor {

        TableAnnotationVisitor() {
            super(ASM4);
        }

        @Override
        public void visit(String name, Object value) {
            if (name.equals("name")) {
                tableName = String.valueOf(value);
            }
        }
    }

    class ClassLoader extends java.lang.ClassLoader {
        public Class defineClass(String name, byte[] b) {
            return defineClass(name, b, 0, b.length);
        }
    }

    class GetterVisitor extends MethodVisitor {

        private String getterName;
        private FieldValueGetter fieldValueGetter;
        private BiConsumer fieldValueSetter;
        private Class fieldValueClass;

        Map<String, Map<String, Object>> annotations = new HashMap<>();

        GetterVisitor(String getterName, FieldValueGetter fieldValueGetter, BiConsumer fieldValueSetter, Class fieldValueClass) {
            super(ASM4);
            this.getterName = getterName;
            this.fieldValueGetter = fieldValueGetter;
            this.fieldValueSetter = fieldValueSetter;
            this.fieldValueClass = fieldValueClass;
        }

        @Override
        public AnnotationVisitor visitAnnotation(String descriptor, final boolean visible) {
            Map<String, Object> annotation = new HashMap<>();
            annotations.put(descriptor, annotation);
            if (descriptor.equals("Ljavax/persistence/Column;")) {
                ColumnAnnotationVisitor columnAnnotationVisitor = new ColumnAnnotationVisitor(annotation);
                return columnAnnotationVisitor;
            } else {
                return super.visitAnnotation(descriptor, visible);
            }
        }

        @Override
        public void visitEnd() {
            String columnName = String.valueOf(annotations.get("Ljavax/persistence/Column;").get("name"));
            Field field;
            if (annotations.containsKey("Ljavax/persistence/Id;")) {
                field = new Id(columnName);
            } else {
                field = new Field(columnName);
            }
            field.setGetterName(getterName);
            field.setFieldValueGetter(fieldValueGetter);
            field.setFieldValueSetter(fieldValueSetter);
            field.setType(fieldValueClass);
            fields.add(field);
            super.visitEnd();
        }
    }

    class ColumnAnnotationVisitor extends AnnotationVisitor {

        private Map<String, Object> annotation;

        ColumnAnnotationVisitor(Map<String, Object> annotation) {
            super(ASM4);
            this.annotation = annotation;
        }

        @Override
        public void visit(String name, Object value) {
            annotation.put(name, value);
            /*if (name.equals("name")) {
                Field field = new Field(String.valueOf(value));
                field.setGetterName(getterName);
                field.setFieldValueGetter(fieldValueGetter);
                field.setFieldValueSetter(fieldValueSetter);
                field.setType(fieldValueClass);
                fields.add(field);
            }*/
        }
    }

    public static void getFile(byte[] bfile, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath+"\\"+fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

}
