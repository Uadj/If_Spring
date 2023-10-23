package com.example.base_shopping.discount;

import com.example.base_shopping.member.Member;
import org.springframework.stereotype.Component;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
