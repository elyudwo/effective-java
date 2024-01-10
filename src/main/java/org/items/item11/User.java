package org.items.item11;

public class User {

    private String name;
    private int number;

    public User(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof User user)) {
            return false;
        }
        return user.name == name && user.number == number;
    }

    @Override
    public int hashCode() {
        return Short.hashCode((short) number);
    }
}
