package com.heyso.Palette.service;


import com.heyso.Palette.domain.MemberTemp;
import com.heyso.Palette.repository.JpaMemberRepository;
import com.heyso.Palette.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository)
    {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public String join(MemberTemp member)
    {
        validateDuplicate(member);
        memberRepository.save(member);
        return member.getUserId();
    }

    public List<MemberTemp> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<MemberTemp> findOne(String userId)
    {
        return memberRepository.findById(userId);
    }

    private void validateDuplicate(MemberTemp member) {
        memberRepository.findById(member.getUserId())
                .ifPresent(m -> {
                    try {
                        throw new IllegalAccessException("이미 존재하는 회원입니다.");
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
