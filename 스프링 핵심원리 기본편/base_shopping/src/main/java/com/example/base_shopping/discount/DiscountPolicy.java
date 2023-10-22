package com.example.base_shopping.discount;

import com.example.base_shopping.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
