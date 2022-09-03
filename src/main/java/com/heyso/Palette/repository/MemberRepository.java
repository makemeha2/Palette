package com.heyso.Palette.repository;

import com.heyso.Palette.domain.MemberTemp;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    MemberTemp save(MemberTemp member);

    Optional<MemberTemp> findById(String id);

    Optional<MemberTemp> findByName(String name);

    List<MemberTemp> findAll();


}
