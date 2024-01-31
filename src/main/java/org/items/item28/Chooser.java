package org.items.item28;

import java.util.Collection;

public class Chooser<T> {
    private final T[] choiceArray;

    public Chooser(Collection<T> choices) {
        choiceArray = (T[]) choices.toArray();
    }
    // choose 메서드 그대로
}