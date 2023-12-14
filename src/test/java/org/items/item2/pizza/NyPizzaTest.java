package org.items.item2.pizza;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.items.item2.pizza.NyPizza.Size.SMALL;
import static org.items.item2.pizza.Pizza.Topping.ONION;
import static org.items.item2.pizza.Pizza.Topping.SAUSAGE;

class NyPizzaTest {

    @Test
    void NyPizza() {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE)
                .addTopping(ONION)
                .build();

        assertThat(pizza.getSize()).isEqualTo(SMALL);
    }

}