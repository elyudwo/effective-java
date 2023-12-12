package org.items.item1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    @Test
    void 이름만_반환() {
        // given
        Member member = Member.from("이영재");

        // when
        String result = member.sayMyName();

        // then
        assertThat(result).isEqualTo("안녕하세요 제 이름은 이영재 이고, 전화번호는 0 입니다");
    }

    @Test
    void 이름_전화번호() {
        // given
        Member member = Member.of("이영재", "010-5601-5");

        // when
        String result = member.sayMyName();

        // then
        assertThat(result).isEqualTo("안녕하세요 제 이름은 이영재 이고, 전화번호는 010-5601-5 입니다");
    }
}