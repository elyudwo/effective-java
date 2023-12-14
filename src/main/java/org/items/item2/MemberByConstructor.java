package org.items.item2;

public class MemberByConstructor {

    private final String name; // 필수
    private final String phoneNumber; // 필수
    private final int age; // 선택
    private final int weight; // 선택
    private final int tall; // 선택


    public MemberByConstructor(String name, String phoneNumber) {
        this(name, phoneNumber, 0);
    }

    public MemberByConstructor(String name, String phoneNumber, int age) {
        this(name, phoneNumber, age, 0);
    }

    public MemberByConstructor(String name, String phoneNumber, int age, int weight) {
        this(name, phoneNumber, age, weight, 0);
    }

    public MemberByConstructor(String name, String phoneNumber, int age, int weight, int tall) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.weight = weight;
        this.tall = tall;
    }
}
