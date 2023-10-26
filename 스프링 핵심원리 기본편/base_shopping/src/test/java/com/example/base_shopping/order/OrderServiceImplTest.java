package com.example.base_shopping.order;

import com.example.base_shopping.AppConfig;
import com.example.base_shopping.discount.FixDiscountPolicy;
import com.example.base_shopping.member.Grade;
import com.example.base_shopping.member.Member;
import com.example.base_shopping.member.MemberService;
import com.example.base_shopping.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "ItemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}