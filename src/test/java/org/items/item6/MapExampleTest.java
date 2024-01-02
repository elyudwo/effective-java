package org.items.item6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class MapExampleTest {

    @Test
    void mapTest() {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 3);
        map.put("2", 1);

        Set<String> strings1 = map.keySet();
        Set<String> strings2 = map.keySet();
        Assertions.assertThat(strings1).isEqualTo(strings2);
    }

}