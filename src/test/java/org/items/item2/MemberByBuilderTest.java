package org.items.item2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class MemberByBuilderTest {

    @Test
    void Builder() {
        /**
         * 정적 내부 클래스의 인스턴스는 외부 클래스를 먼저 생성하지 않아도 생성 가능하다. (Java의 정석 408p)
         * 메소드 체이닝을 이용해 . 으로 연쇄 호출
         */
        MemberByBuilder member = new MemberByBuilder.Builder("이영재", "010")
                .age(25)
                .tall(175)
                .weight(75)
                .build();

        Assertions.assertThat(member.getName()).isEqualTo("이영재");
    }

}