package ru.job4j.di;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {
    private final Map<String, Object> elements = new HashMap<>();

    public void reg(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        if (constructors.length > 1) {
            throw new IllegalStateException("Class has multiple constructors : " + cl.getCanonicalName());
        }
        Constructor constructor = constructors[0];
        List<Object> args = new ArrayList<>();
        for (Class arg : constructor.getParameterTypes()) {
            if (!elements.containsKey(arg.getCanonicalName())) {
                throw new IllegalStateException("Object doesn't found in context : " + arg.getCanonicalName());
            }
            args.add(elements.get(arg.getCanonicalName()));
        }
        try {
            elements.put(cl.getCanonicalName(), constructor.newInstance(args.toArray()));
        } catch (Exception e) {
            throw new IllegalStateException("Couldn't create an instance of : " + cl.getCanonicalName(), e);
        }
    }

    public <T> T get(Class<T> instance) {
        return (T) elements.get(instance.getCanonicalName());
    }
}
