package sep.entity.resolver.asm.hibernate;

import org.objectweb.asm.ClassWriter;

import static org.objectweb.asm.Opcodes.ASM4;

public class FieldValueGetterClassWriter extends ClassWriter {

    public FieldValueGetterClassWriter() {
        super(ASM4);
    }

}
