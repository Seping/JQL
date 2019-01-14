package sep.entity.resolver.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import sep.entity.resolver.EntityResolver;
import sep.entity.struct.entity.Entity;
import sep.entity.struct.entity.EntityImpl;

import java.io.IOException;

public class AnnotationBasicASMResolver implements EntityResolver {

    public Entity resolve(Class entityClass) {
        EntityClassVisitor classVistor = new EntityClassVisitor(entityClass);
        ClassReader classReader = null;
        try {
            classReader = new ClassReader(entityClass.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        classReader.accept(classVistor, ClassWriter.COMPUTE_MAXS);
        return classVistor.getEntity();
    }
}
