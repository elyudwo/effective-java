package org.items.item3;

public class GenericSingletonFactory<T> {

    private static final GenericSingletonFactory<Object> instance = new GenericSingletonFactory();

    private GenericSingletonFactory() {}

    public static <E> GenericSingletonFactory<E> getInstance() {
        return (GenericSingletonFactory<E>) instance;
    }

}
