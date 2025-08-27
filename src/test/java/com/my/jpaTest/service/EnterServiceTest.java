package com.my.jpaTest.service;

import com.my.jpaTest.entity.GirlGroup;
import com.my.jpaTest.entity.IdolMember;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class EnterServiceTest {
    @Autowired
    EntityManager em;

    @Test
    @DisplayName("데이터 입력 테스트")
    void dataInputTest() {
        enterService.initData();
    }

    // 1. 지수가 속한 걸그룹 이름과 엔터테인먼트 회사 이름 출력하기
    @Test
    @DisplayName("문제1")
    void 문제1() {
        IdolMember jisu = em.find(IdolMember.class, "지수");
        String groupName = jisu.getGirlGroup().getG_name();
        String enterName = jisu.getGirlGroup().getEntertainment().getE_name();

    }

    //2. blackpink 멤버 리스트 출력하기
    @Test
    @DisplayName("문제2")
    void 문제2() {
        GirlGroup group = em.find(GirlGroup.class, "blackpink");
        group.getIdolMembers().forEach(x-> System.out.println(x.getM_name()));
    }
}
