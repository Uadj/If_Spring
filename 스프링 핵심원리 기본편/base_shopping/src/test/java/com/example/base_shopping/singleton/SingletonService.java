package com.example.base_shopping.singleton;

import com.example.base_shopping.AppConfig;
import com.example.base_shopping.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){

    }
    public void logic(){
        System.out.println("싱글톤 객체 호출");
    }
}
