package com.alunoonline.api.repository;

import com.alunoonline.api.model.ContentClasses;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentClassesRepository extends CrudRepository<ContentClasses, String> {

}
