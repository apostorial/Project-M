package com.apostorial.projectm.repositories;

import com.apostorial.projectm.entities.Studio;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudioRepository extends MongoRepository<Studio, String> {
    List<Studio> findByUserId(String userId);
}
