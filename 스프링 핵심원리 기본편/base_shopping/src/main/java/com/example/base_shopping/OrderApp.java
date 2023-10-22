package com.example.base_shopping;

import com.example.base_shopping.member.Grade;
import com.example.base_shopping.member.Member;
import com.example.base_shopping.member.MemberService;
import com.example.base_shopping.member.MemberServiceImpl;
import com.example.base_shopping.order.Order;
import com.example.base_shopping.order.OrderService;
import com.example.base_shopping.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        Order order = orderService.createOrder(1L, "itemA", 10000);
        System.out.println("order = " + order);
    }

}
