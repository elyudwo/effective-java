package org.items.item14;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {


    @Test
    void sort_테스트() {
        List<Member> members = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

//        Collections.sort(members);
        Collections.sort(list);
    }

    @Test
    void null_checking() {
        Long a = null;
        if(a == 1L) {
            System.out.println("HI");
        }
    }

    void hi(Long b) {
        System.out.println(b);
    }
}