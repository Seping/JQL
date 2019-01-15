package sep.entity.resolver.asm;

import org.objectweb.asm.*;
import sep.entity.struct.entity.Entity;
import sep.entity.struct.entity.EntityImpl;
import sep.entity.struct.field.Field;
import sep.entity.struct.field.factory.FieldFactory;
import sep.entity.struct.field.special.*;
import sep.jql.Attribute;

import java.io.*;
import java.lang.invoke.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import static org.objectweb.asm.Opcodes.*;

public class EntityClassVisitor<T> extends ClassVisitor {

    private String internalEntityName;
    private Class<T> entityClass;

    private String tableName;
    private Supplier<T> supplier;
    private List<Field<T, ?>> fields = new ArrayList<>();

    private Entity<T> entity;

    //Getter
    public Entity<T> getEntity() {
        return entity;
    }

    public EntityClassVisitor(Class<T> entityClass) {
        super(ASM4);
        this.entityClass = entityClass;
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.internalEntityName = name;
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        if (descriptor.equals("Lsep/annotation/Table;")) {
            return new AnnotationVisitor(ASM4) {
                @Override
                public void visit(String name, Object value) {
                    if (name.equals("name")) {
                        tableName = String.valueOf(value);
                    }
                }
            };
        }
        else return super.visitAnnotation(descriptor, visible);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        if (name.equals("<init>")) {
            supplier = createEntitySupplier();
        } else if (name.startsWith("get")) {
            return new FieldGetterVisitor(getFieldValueType(descriptor),
                    createFieldValueSetter(name, descriptor),
                    createFieldAttribute(name, descriptor));
        }
        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }

    private Supplier<T> createEntitySupplier() {
        ClassWriter entitySuppierClassWriter = new ClassWriter(ASM4);
        entitySuppierClassWriter.visit(V1_8,
                ACC_PUBLIC + ACC_SUPER,
                "sep/entity/struct/EntitySupplier$" + tableName,
                "Ljava/lang/Object;Ljava/util/function/Supplier<L" + internalEntityName +";>;",
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
        byte[] b = entitySuppierClassWriter.toByteArray();
        Class newEntitySupplierClass = new ClassLoader().defineClass("sep.entity.struct.EntitySupplier$" + tableName, b);
        try {
            return (Supplier<T>) newEntitySupplierClass.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param descriptor the descriptor of {@code visitMethod()}.
     *                   It's the internal name of the method's return type, something like "Ljava/lang/Integer;"
     */
    private Class<?> getFieldValueType(String descriptor) {
        try {
            return Class.forName(descriptor.replaceFirst("\\(\\)L", "").replaceAll(";", "").replaceAll("/", "."));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private BiConsumer<T, ?> createFieldValueSetter(String name, String descriptor) {
        String paramInternalName = descriptor.replaceFirst("\\(\\)L", "").replaceAll(";", "");
        ClassWriter fieldValueSetterClassWriter = new ClassWriter(ASM4);
        fieldValueSetterClassWriter.visit(
                V1_8,
                ACC_PUBLIC + ACC_SUPER,
                "sep/entity/struct/field/value/FieldValueSetter$" + tableName + "$" + name.replaceFirst("get", "set"),
                "Ljava/lang/Object;Ljava/util/function/BiConsumer<L" + internalEntityName +";" + paramInternalName + ">;",
                "java/lang/Object",
                new String[] {"java/util/function/BiConsumer"}
        );
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
        try {
            return (BiConsumer<T, ?>) newFieldValueSetterClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Attribute<T> createFieldAttribute(String name, String descriptor) {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {
            Class<?> paramType = getFieldValueType(descriptor);
            MethodHandle getter = lookup.findVirtual(entityClass, name, MethodType.methodType(paramType));
            MethodType invokedType = MethodType.methodType(Attribute.class);
            CallSite callSite = LambdaMetafactory.altMetafactory(lookup,
                    "get",
                    invokedType,
                    MethodType.methodType(Object.class, Object.class),
                    getter,
                    MethodType.methodType(Object.class, entityClass),
                    LambdaMetafactory.FLAG_SERIALIZABLE);
            MethodHandle factory = callSite.getTarget();
            Attribute<T> attribute = (Attribute<T>) factory.invoke();
            return attribute;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    class FieldGetterVisitor extends MethodVisitor {

        Class<?> fieldValueType;
        BiConsumer<T, ?> fieldValueSetter;
        Attribute<T> fieldAttribute;

        Map<String, Object> annotationValues = new HashMap<>();

        public FieldGetterVisitor(Class<?> fieldValueType,
                BiConsumer<T, ?> fieldValueSetter,
                Attribute<T> fieldAttribute) {
            super(ASM4);
            this.fieldValueType = fieldValueType;
            this.fieldValueSetter = fieldValueSetter;
            this.fieldAttribute = fieldAttribute;
        }

        @Override
        public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
            if (descriptor.equals("Lsep/annotation/Column;") || descriptor.equals("Lsep/annotation/Id;")) {
                return new AnnotationVisitor(ASM4) {
                    @Override
                    public void visit(String name, Object value) {
                        annotationValues.put(name, value);
                    }
                };
            } else {
                return super.visitAnnotation(descriptor, visible);
            }
        }

        @Override
        public void visitEnd() {
            String fieldClassName = annotationValues.get("field") != null ?
                    ((Type) annotationValues.get("field")).getClassName() : "sep.entity.struct.field.BasicField";
            String fieldClassInternalName = fieldClassName.replaceAll("\\.", "/");
            String columnName = annotationValues.get("columnName").toString();
            String valueTypeInternalName = fieldValueType.getName().replaceAll("\\.", "/");

            ClassWriter classWriter = new ClassWriter(ASM4);
            classWriter.visit(V1_8,
                    ACC_PUBLIC + ACC_SUPER,
                    fieldClassInternalName + "$" + tableName + "$" + columnName,
                    "L"+fieldClassInternalName+"<L" + internalEntityName +";L"  + valueTypeInternalName + ";>;",
                    fieldClassInternalName,
                    null);
            MethodVisitor constructorVisitor = classWriter.visitMethod(ACC_PUBLIC,
                    "<init>",
                    "()V",
                    null,
                    null);
            constructorVisitor.visitMaxs(1, 2);
            constructorVisitor.visitVarInsn(ALOAD, 0);
            constructorVisitor.visitMethodInsn(INVOKESPECIAL,
                    fieldClassInternalName,
                    "<init>",
                    "()V",
                    false);
            constructorVisitor.visitInsn(RETURN);
            constructorVisitor.visitEnd();

            String updateValue = (String) annotationValues.get("updateValue");
            if (fieldClassName.equals("sep.entity.struct.field.BasicField") && updateValue != null) {
                MethodVisitor updateValueVisitor = classWriter.visitMethod(ACC_PUBLIC,
                        "getUpdateValue",
                        "()L" + valueTypeInternalName + ";",
                        null,
                        null);
                updateValueVisitor.visitMaxs(2, 1);
                updateValueVisitor.visitLdcInsn(updateValue);
                updateValueVisitor.visitLdcInsn(Type.getType("L" + valueTypeInternalName + ";"));
                updateValueVisitor.visitMethodInsn(INVOKESTATIC,
                        "sep/util/SQLStringUtil",
                        "stringToSQLValue",
                        "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;",
                        false);
                updateValueVisitor.visitTypeInsn(CHECKCAST, valueTypeInternalName);
                updateValueVisitor.visitInsn(ARETURN);
                updateValueVisitor.visitEnd();

                MethodVisitor parentUpdateValueVisitor = classWriter.visitMethod(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC,
                        "getUpdateValue",
                        "()Ljava/lang/Object;",
                        null,
                        null);
                parentUpdateValueVisitor.visitMaxs(1, 1);
                parentUpdateValueVisitor.visitVarInsn(ALOAD, 0);
                parentUpdateValueVisitor.visitMethodInsn(INVOKEVIRTUAL,
                        fieldClassInternalName + "$" + tableName + "$" + columnName,
                        "getUpdateValue",
                        "()L" + valueTypeInternalName + ";",
                        false);
                parentUpdateValueVisitor.visitInsn(ARETURN);
                parentUpdateValueVisitor.visitEnd();
            }

            String insertValue = (String) annotationValues.get("insertValue");
            if (fieldClassName.equals("sep.entity.struct.field.BasicField") && insertValue != null) {
                MethodVisitor insertValueVisitor = classWriter.visitMethod(ACC_PUBLIC,
                        "getInsertValue",
                        "()L" + valueTypeInternalName + ";",
                        null,
                        null);
                insertValueVisitor.visitMaxs(2, 1);
                insertValueVisitor.visitLdcInsn(insertValue);
                insertValueVisitor.visitLdcInsn(Type.getType("L" + valueTypeInternalName + ";"));
                insertValueVisitor.visitMethodInsn(INVOKESTATIC,
                        "sep/util/SQLStringUtil",
                        "stringToSQLValue",
                        "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;",
                        false);
                insertValueVisitor.visitTypeInsn(CHECKCAST, valueTypeInternalName);
                insertValueVisitor.visitInsn(ARETURN);
                insertValueVisitor.visitEnd();

                MethodVisitor parentInsertValueVisitor = classWriter.visitMethod(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC,
                        "getInsertValue",
                        "()Ljava/lang/Object;",
                        null,
                        null);
                parentInsertValueVisitor.visitMaxs(1, 1);
                parentInsertValueVisitor.visitVarInsn(ALOAD, 0);
                parentInsertValueVisitor.visitMethodInsn(INVOKEVIRTUAL,
                        fieldClassInternalName + "$" + tableName + "$" + columnName,
                        "getInsertValue",
                        "()L" + valueTypeInternalName + ";",
                        false);
                parentInsertValueVisitor.visitInsn(ARETURN);
                parentInsertValueVisitor.visitEnd();
            }

            String queryValue = (String) annotationValues.get("queryValue");
            if (fieldClassName.equals("sep.entity.struct.field.BasicField") && queryValue != null) {
                MethodVisitor queryValueVisitor = classWriter.visitMethod(ACC_PUBLIC,
                        "getQueryValue",
                        "()L" + valueTypeInternalName + ";",
                        null,
                        null);
                queryValueVisitor.visitMaxs(2, 1);
                queryValueVisitor.visitLdcInsn(queryValue);
                queryValueVisitor.visitLdcInsn(Type.getType("L" + valueTypeInternalName + ";"));
                queryValueVisitor.visitMethodInsn(INVOKESTATIC,
                        "sep/util/SQLStringUtil",
                        "stringToSQLValue",
                        "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;",
                        false);
                queryValueVisitor.visitTypeInsn(CHECKCAST, valueTypeInternalName);
                queryValueVisitor.visitInsn(ARETURN);
                queryValueVisitor.visitEnd();

                MethodVisitor parentQueryValueVisitor = classWriter.visitMethod(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC,
                        "getQueryValue",
                        "()Ljava/lang/Object;",
                        null,
                        null);
                parentQueryValueVisitor.visitMaxs(1, 1);
                parentQueryValueVisitor.visitVarInsn(ALOAD, 0);
                parentQueryValueVisitor.visitMethodInsn(INVOKEVIRTUAL,
                        fieldClassInternalName + "$" + tableName + "$" + columnName,
                        "getQueryValue",
                        "()L" + valueTypeInternalName + ";",
                        false);
                parentQueryValueVisitor.visitInsn(ARETURN);
                parentQueryValueVisitor.visitEnd();
            }

            String tombstoneValue = (String) annotationValues.get("tombstoneValue");
            if (fieldClassName.equals("sep.entity.struct.field.BasicField") && tombstoneValue != null) {
                MethodVisitor tombstoneValueVisitor = classWriter.visitMethod(ACC_PUBLIC,
                        "getTombstoneValue",
                        "()L" + valueTypeInternalName + ";",
                        null,
                        null);
                tombstoneValueVisitor.visitMaxs(2, 1);
                tombstoneValueVisitor.visitLdcInsn(tombstoneValue);
                tombstoneValueVisitor.visitLdcInsn(Type.getType("L" + valueTypeInternalName + ";"));
                tombstoneValueVisitor.visitMethodInsn(INVOKESTATIC,
                        "sep/util/SQLStringUtil",
                        "stringToSQLValue",
                        "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;",
                        false);
                tombstoneValueVisitor.visitTypeInsn(CHECKCAST, valueTypeInternalName);
                tombstoneValueVisitor.visitInsn(ARETURN);
                tombstoneValueVisitor.visitEnd();

                MethodVisitor parentTombstoneValueVisitor = classWriter.visitMethod(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC,
                        "getTombstoneValue",
                        "()Ljava/lang/Object;",
                        null,
                        null);
                parentTombstoneValueVisitor.visitMaxs(1, 1);
                parentTombstoneValueVisitor.visitVarInsn(ALOAD, 0);
                parentTombstoneValueVisitor.visitMethodInsn(INVOKEVIRTUAL,
                        fieldClassInternalName + "$" + tableName + "$" + columnName,
                        "getTombstoneValue",
                        "()L" + valueTypeInternalName + ";",
                        false);
                parentTombstoneValueVisitor.visitInsn(ARETURN);
                parentTombstoneValueVisitor.visitEnd();
            }

            classWriter.visitEnd();
            byte[] b = classWriter.toByteArray();
            Class newFieldClass = new ClassLoader().defineClass(fieldClassName + "$" + tableName + "$" + columnName, b);
            Field field = null;
            try {
                field = (Field) newFieldClass.getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }

            field.setValueType(fieldValueType);
            field.setAttribute(fieldAttribute);
            field.setColumnName(columnName);

            fields.add(field);
        }
    }

    @Override
    public void visitEnd() {
        entity = new EntityImpl<>(entityClass, tableName, supplier);
        for (Field field : fields) {
            field.setEntity(entity);
            entity.addField(field);
        }
    }

    //Only for test
    private static void getFile(byte[] bfile, String filePath, String fileName) {
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
