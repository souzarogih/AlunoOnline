package com.alunoonline.api.repository;

import com.alunoonline.api.model.ContentClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentClassRepository extends CrudRepository<ContentClass, String> {

}
