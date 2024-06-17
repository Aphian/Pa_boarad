package com.study;

import com.study.domain.member.Gender;
import com.study.domain.member.Member;
import com.study.domain.member.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

//    @Test
//    void saveMember() {
//        Member saveParams = Member.builder()
//                .loginId("test")
//                .password("1234")
//                .name("홍길동")
//                .gender(Gender.M)
//                .birthday(LocalDate.of(1991, 01, 01))
//                .deleteYn(false)
//                .build();
//
//        Member member = memberRepository.save(saveParams);
//        Assertions.assertEquals(member.getLoginId(), "test");
//    }
    
//    @Test
//    void findAllMember() {
//        memberRepository.findAll();
//    }
//
//    @Test
//    void findMemberById() {
//        Member member = memberRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException());
//        Assertions.assertEquals(member.getLoginId(), "test");
//    }
//
    @Test
    void deleteMemberById() {
        memberRepository.deleteById(1L);
    }

}
