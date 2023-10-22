package com.example.base_shopping.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
