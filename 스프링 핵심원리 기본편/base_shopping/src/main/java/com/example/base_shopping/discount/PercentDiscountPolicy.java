package com.example.base_shopping.discount;

import com.example.base_shopping.annotation.MainDiscountPolicy;
import com.example.base_shopping.member.Grade;
import com.example.base_shopping.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class PercentDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 20;
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
