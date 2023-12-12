package org.items.item1;

import static java.lang.String.format;

public class Member {

    private final String name;
    private final String phoneNumber;

    private Member(String name) {
        this(name, "0");
    }

    private Member(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public static Member from(String name) {
        return new Member(name);
    }

    public static Member of(String name, String phoneNumber) {
        return new Member(name, phoneNumber);
    }

    public String sayMyName() {
        return format("안녕하세요 제 이름은 %s 이고, 전화번호는 %s 입니다", name, phoneNumber);
    }
}
