package org.items.item1;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class ServiceProvider {

    static Map<String, College> collegeMap = new HashMap<>();

    static {
        ServiceLoader<College> loader = ServiceLoader.load(College.class);
        loader.forEach(
                college -> collegeMap.put(college.getName(), college)
        );
    }

    public static College getCollege(String name) {
        College college = collegeMap.get(name);

        if(college == null) {
            throw new IllegalArgumentException("등록되지 않은 대학 이름입니다.");
        }

        return college;
    }
}
