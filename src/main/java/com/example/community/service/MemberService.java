package com.example.community.service;

import com.example.community.dto.MemberDto;
import com.example.community.entitiy.Member;
import com.example.community.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void save(MemberDto memberDto) {
        if (memberRepository.existsByMemberId(memberDto.getMemberId())) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
        String encodedPw = passwordEncoder.encode(memberDto.getMemberPw()); // 비밀번호 암호화
        Member member = memberDto.toEntity(encodedPw); // 비밀번호 암호화 entity로 보내기

        memberRepository.save(member); // 멤버 저장
    }
}
