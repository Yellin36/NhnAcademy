package org.example.yerin.tdd.mart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

class CartTest {
    Cart cart;

    @BeforeEach
    void setCart() {
        cart = new Cart();
    }
    @Test
    void addItem() {
        Goods something = mock(Goods.class);
        cart.addItem(something);

        assertThat(cart.getAllItem().get(0)).isEqualTo(something);
    }
    @Test
    @DisplayName("장바구니에는 아이템이 10개까지 허용된다. 그 이상인 경우 예외 발생")
    void addItem_not10More() {
        List<Goods> somethings = List.of(
                mock(Goods.class),
                mock(Goods.class),
                mock(Goods.class),
                mock(Goods.class),
                mock(Goods.class),
                mock(Goods.class),
                mock(Goods.class),
                mock(Goods.class),
                mock(Goods.class),
                mock(Goods.class),
                mock(Goods.class)   //11개
        );
        for(int i=0; i<10; i++) {
            cart.addItem(somethings.get(i));
        }
        assertThatThrownBy(() -> cart.addItem(somethings.get(10)))
                .isInstanceOf(cartCapacityOverException.class);
    }
    @Test
    void getAllItems() {
        List<Goods> somethings = List.of(
                mock(Goods.class),
                mock(Goods.class),
                mock(Goods.class),
                mock(Goods.class),
                mock(Goods.class),
                mock(Goods.class),
                mock(Goods.class),
                mock(Goods.class),
                mock(Goods.class),
                mock(Goods.class)
        );
        for(Goods something: somethings) {
            cart.addItem(something);
        }
        assertThat(cart.getAllItem()).isEqualTo(somethings);

    }
}