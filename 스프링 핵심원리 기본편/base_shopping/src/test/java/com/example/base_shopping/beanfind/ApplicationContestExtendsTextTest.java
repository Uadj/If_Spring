package com.example.base_shopping.beanfind;

import com.example.base_shopping.AppConfig;
import com.example.base_shopping.discount.DiscountPolicy;
import com.example.base_shopping.discount.FixDiscountPolicy;
import com.example.base_shopping.discount.PercentDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationContestExtendsTextTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입 조회 시 자식이 둘 이상이면 중복 오류 발생")
    void findBeanByParentTypeDuplicate(){
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));
    }
    @Test
    @DisplayName("부모 타입 조회 시 자식이 둘 이상이면 빈 이름 지정")
    void findBeanByParentTypeBeanName(){
        DiscountPolicy percentDiscountPolicy = ac.getBean("percentDiscountPolicy", DiscountPolicy.class);
        assertThat(percentDiscountPolicy).isInstanceOf(PercentDiscountPolicy.class);
    }
    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubType(){
        PercentDiscountPolicy bean = ac.getBean(PercentDiscountPolicy.class);
        assertThat(bean).isInstanceOf(PercentDiscountPolicy.class);
    }
    @Test
    @DisplayName("부모 타입으로 모두 조회")
    void findAllBeanByParentType(){
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);
        for(String key : beansOfType.keySet()){
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }
    @Test
    @DisplayName("부모 타입으로 모두 조회 - Object")
    void findAllBeanByObjectType(){
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for(String key : beansOfType.keySet()){
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }
    @Configuration
    static class TestConfig{
        @Bean
        public DiscountPolicy percentDiscountPolicy(){
            return new PercentDiscountPolicy();
        }
        @Bean
        public DiscountPolicy fixDiscountPolicy(){
            return new FixDiscountPolicy();
        }
    }

}