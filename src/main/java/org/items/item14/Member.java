package org.items.item14;

public class Member {

    private int number;
    private String name;

    public Member(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}