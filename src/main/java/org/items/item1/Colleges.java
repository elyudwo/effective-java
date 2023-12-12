package org.items.item1;

import java.util.HashMap;
import java.util.Map;

public class Colleges {

    static Map<String, College> collegeMap = new HashMap<>();

    static {
        collegeMap.put("군대", new Army());
        collegeMap.put("붕대", new Bandage());
    }

    public static College getCollege(String name) {
        College college = collegeMap.get(name);

        if(college == null) {
            throw new IllegalArgumentException("등록되지 않은 대학 이름입니다.");
        }

        return college;
    }

}
