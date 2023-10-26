package com.example.base_shopping.discount;

import com.example.base_shopping.member.Grade;
import com.example.base_shopping.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP)
        {
            return discountFixAmount;
        }
        else{
            return 0;
        }
    }

}
