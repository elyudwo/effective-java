package org.items.item26;

import java.util.*;

public class RawCheck {

    private List<String> stamp = new ArrayList<>();

    public void addStamp() {
        unsafeAdd(stamp, Integer.valueOf(25));
        System.out.println(stamp.get(0));
    }

    public void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}
