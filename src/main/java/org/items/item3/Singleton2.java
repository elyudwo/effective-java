package org.items.item3;

import java.io.Serializable;
import java.util.Objects;

public class Singleton2 implements Serializable {

    private static final Singleton2 singleton = new Singleton2();

    public static Singleton2 getInstance() {
        return singleton;
    }

    private Object readResolve() {
        return singleton;
    }
}
