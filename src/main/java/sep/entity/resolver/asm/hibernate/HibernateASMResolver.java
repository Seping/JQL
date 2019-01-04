package sep.entity.resolver.asm.hibernate;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import sep.entity.resolver.EntityResolver;
import sep.entity.struct.entity.Entity;

import java.io.IOException;

public class HibernateASMResolver implements EntityResolver {

    public Entity resolve(Class entityClass) {
        HibernateEntityClassVisitor classVistor = new HibernateEntityClassVisitor();
        ClassReader classReader = null;
        try {
            classReader = new ClassReader(entityClass.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        classReader.accept(classVistor, ClassWriter.COMPUTE_MAXS);
        return new Entity(entityClass, classVistor.getTableName(), classVistor.getFields(), classVistor.getSupplier());
    }
}
