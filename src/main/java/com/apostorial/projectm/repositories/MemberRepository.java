package com.apostorial.projectm.repositories;

import com.apostorial.projectm.entities.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MemberRepository extends MongoRepository<Member, String> {
    List<Member> findByStudioId(String studioId);
}
