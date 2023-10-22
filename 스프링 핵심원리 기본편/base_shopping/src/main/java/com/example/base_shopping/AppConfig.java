package com.example.base_shopping;

import com.example.base_shopping.discount.DiscountPolicy;
import com.example.base_shopping.discount.FixDiscountPolicy;
import com.example.base_shopping.member.MemberRepository;
import com.example.base_shopping.member.MemberService;
import com.example.base_shopping.member.MemberServiceImpl;
import com.example.base_shopping.member.MemoryMemberRepository;
import com.example.base_shopping.order.OrderService;
import com.example.base_shopping.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
