package com.example.base_shopping.discount;

import com.example.base_shopping.member.Grade;
import com.example.base_shopping.member.Member;
import com.example.base_shopping.order.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PercentDiscountPolicyTest {

    PercentDiscountPolicy percentDiscountPolicy = new PercentDiscountPolicy();

    @Test
    void discount_VIP() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        int discount = percentDiscountPolicy.discount(member, 10000);

        Assertions.assertThat(discount).isEqualTo(1000);
    }
    @Test
    void discount_BASIC() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.BASIC);

        int discount = percentDiscountPolicy.discount(member, 10000);

        Assertions.assertThat(discount).isEqualTo(0);
    }
}