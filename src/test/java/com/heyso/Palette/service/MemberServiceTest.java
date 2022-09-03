package com.heyso.Palette.service;

import com.heyso.Palette.domain.MemberTemp;
import com.heyso.Palette.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {
        MemberTemp member = new MemberTemp();
        member.setUserId("testman");
        member.setPassword("1234");
        member.setUserName("테스트맨");
        member.setUseYN(true);
        member.setCertificateYN(false);
        member.setCreateDate(new Date());
        member.setUpdateDate(new Date());

        String saveId = memberService.join(member);

        MemberTemp findMember = memberService.findOne(saveId).get();
        assertThat(member.getUserName()).isEqualTo(findMember.getUserName());
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}