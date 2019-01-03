package sep.entity.resolver.asm.hibernate;

import org.objectweb.asm.ClassWriter;

import static org.objectweb.asm.Opcodes.ASM4;

public class EntitySuppierClassWriter extends ClassWriter {
    public EntitySuppierClassWriter() {
        super(ASM4);
    }
}
