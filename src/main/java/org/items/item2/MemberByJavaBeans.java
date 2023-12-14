package org.items.item2;

public class MemberByJavaBeans {

    private String name; // 필수
    private String phoneNumber; // 필수
    private int age = 0; // 선택
    private int weight = 0; // 선택
    private int tall = 0; // 선택

    public MemberByJavaBeans() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setTall(int tall) {
        this.tall = tall;
    }

}

