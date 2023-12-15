package org.items.item3;

import org.junit.jupiter.api.Test;

class GenericSingletonFactoryTest {

    @Test
    void getInstance() {
    }

    @Test
    void say() {
        GenericSingletonFactory<Integer> instance = GenericSingletonFactory.getInstance();
        Integer a = 30;
    }
}