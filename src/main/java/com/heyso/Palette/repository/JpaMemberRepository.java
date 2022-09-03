package com.heyso.Palette.repository;

import com.heyso.Palette.domain.MemberTemp;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em)
    {
        this.em = em;
    }

    @Override
    public MemberTemp save(MemberTemp member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<MemberTemp> findById(String id) {
        List<MemberTemp> result = em.createQuery("select m from MemberTemp m where m.userId = :userId", MemberTemp.class)
                .setParameter("userId", id)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public Optional<MemberTemp> findByName(String name) {
        List<MemberTemp> list = em.createQuery("select m from MemberTemp m where m.userName = :userName", MemberTemp.class)
                .setParameter("userName", name)
                .getResultList();

        return list.stream().findAny();
    }

    @Override
    public List<MemberTemp> findAll() {
        return em.createQuery("select m from MemberTemp m", MemberTemp.class)
                .getResultList();
    }
}
