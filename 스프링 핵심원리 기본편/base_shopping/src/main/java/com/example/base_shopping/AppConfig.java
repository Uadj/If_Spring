package com.example.base_shopping;

import com.example.base_shopping.discount.DiscountPolicy;
import com.example.base_shopping.discount.FixDiscountPolicy;
import com.example.base_shopping.member.MemberRepository;
import com.example.base_shopping.member.MemberService;
import com.example.base_shopping.member.MemberServiceImpl;
import com.example.base_shopping.member.MemoryMemberRepository;
import com.example.base_shopping.order.OrderService;
import com.example.base_shopping.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
