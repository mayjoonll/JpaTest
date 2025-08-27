package com.my.jpaTest.service;

import com.my.jpaTest.entity.Entertainment;
import com.my.jpaTest.entity.GirlGroup;
import com.my.jpaTest.entity.IdolMember;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EnterService {
    @Autowired
    public void initData() {
        // 엔터생성
        Entertainment starship = Entertainment.builder()
                .e_id("starship")
                .e_name("스타쉽")
                .build();

        // 그룹생성, 엔터 등록
        GirlGroup ive = GirlGroup.builder()
                .g_id("ive")
                .g_name("아이브")
                .entertainment(starship)
                .build();
        // 아이돌생성, 그룹 등록
        IdolMember ahn = IdolMember.builder()
                .m_id("안유진")
                .m_name("유진")
                .girlGroup(ive)
                .build();
        // 엔터에 그룹리스트 등록
        starship.getGirlGroups().add(ive);
        // 그룹에 아이돌리스트 등록
        ive.getIdolMembers().add(ahn);
        // 스타쉽 저장
        em.pers
        // 와이지 저장
    }
}
