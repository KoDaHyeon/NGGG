package com.example.NGGG.repository;


import com.example.NGGG.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(int no) {
        return em.find(Member.class, no);
    }

    public List<Member> findById(String id) {
        return em.createQuery("select m from Member m where m.member_id = :member_id", Member.class)
                .setParameter("member_id", id)
                .getResultList();
    }

    public List<Member> findByNickname(String nickname) {
        return em.createQuery("select m from Member m where m.member_nickname = :member_nickname", Member.class)
                .setParameter("member_nickname", nickname)
                .getResultList();
    }

    public List<Member> findByEmail(String email) {
        return em.createQuery("select m from Member m where m.member_email = :member_email", Member.class)
                .setParameter("member_email", email)
                .getResultList();
    }

}
