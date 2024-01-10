package org.items.item11;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void 해시맵_테스트() {
        Map<User, Integer> userMap = new HashMap<>();

        userMap.put(new User("이영재", 201801686), 25);
        Integer number = userMap.get(new User("이영재", 201801686));

        System.out.println(number);
        assertThat(number).isEqualTo(25);
    }
}