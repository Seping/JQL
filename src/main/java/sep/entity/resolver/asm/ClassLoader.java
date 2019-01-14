package sep.entity.resolver.asm;

public class ClassLoader extends java.lang.ClassLoader {
    public Class defineClass(String name, byte[] b) {
        return defineClass(name, b, 0, b.length);
    }
}
