package org.items.item2;

public class MemberByBuilder {

    private final String name; // 필수
    private final String phoneNumber; // 필수
    private final int age; // 선택
    private final int weight; // 선택
    private final int tall; // 선택

    public static class Builder {
        private final String name;
        private final String phoneNumber;

        private int age;
        private int weight;
        private int tall;

        public Builder(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder tall(int tall) {
            this.tall = tall;
            return this;
        }

        public MemberByBuilder build() {
            return new MemberByBuilder(this);
        }
    }

    public String getName() {
        return name;
    }

    private MemberByBuilder(Builder builder) {
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.age = builder.age;
        this.weight = builder.weight;
        this.tall = builder.tall;
    }

}
