import java.util.*;

public abstract class ObjectPlus {
    private static Map<Class<?>, List<Object>> extensions = new HashMap<>();

    protected static void addExtension(Class<?> cls, Object obj) {
        if (!extensions.containsKey(cls)) {
            extensions.put(cls, new ArrayList<>());
        }
        extensions.get(cls).add(obj);
    }

    public static List<Object> getExtension(Class<?> cls) {
        if (!extensions.containsKey(cls)) {
            throw new RuntimeException("No extension for class: " + cls.getName());
        }
        return extensions.get(cls);
    }
}
