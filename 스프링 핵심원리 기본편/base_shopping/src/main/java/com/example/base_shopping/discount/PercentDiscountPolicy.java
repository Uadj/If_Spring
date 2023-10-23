package com.example.base_shopping.discount;

import com.example.base_shopping.member.Grade;
import com.example.base_shopping.member.Member;
import org.springframework.stereotype.Component;

@Component
public class PercentDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP)
        {
            return price * discountPercent/100;
        }
        else{
            return 0;
        }
    }

}
