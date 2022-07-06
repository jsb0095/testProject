package com.example.test_ex;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberEntity findById(Long member_id) {
       return memberRepository.findById(member_id).get();
    }
}
