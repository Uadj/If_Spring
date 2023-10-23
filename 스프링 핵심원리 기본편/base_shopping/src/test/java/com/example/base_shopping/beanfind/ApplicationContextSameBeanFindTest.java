package com.example.base_shopping.beanfind;

import com.example.base_shopping.AppConfig;
import com.example.base_shopping.member.MemberRepository;
import com.example.base_shopping.member.MemberService;
import com.example.base_shopping.member.MemberServiceImpl;
import com.example.base_shopping.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("같은 타입으로 2개 이상 시 타입 조회 중복 오류 발생")
    void findBeanByTypeDuplicate(){
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, ()-> ac.getBean(MemberRepository.class));
    }
    @Test
    @DisplayName("같은 타입 2개 이상 시 빈 이름 지정 조회")
    void findBeanByName(){
            MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
            assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }
    @Test
    @DisplayName("특정 타입 모두 조회")
    void findAllBeanByType(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for(String key : beansOfType.keySet()){
            System.out.println("key = " + key + " value = " + beansOfType);
            assertThat(beansOfType.size()).isEqualTo(2);
        }
    }
    @Configuration
    static class SameBeanConfig{
        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }
}
