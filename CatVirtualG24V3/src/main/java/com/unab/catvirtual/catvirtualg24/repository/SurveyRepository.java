package com.unab.catvirtual.catvirtualg24.repository;

import com.unab.catvirtual.catvirtualg24.entity.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SurveyRepository extends MongoRepository<Survey,String> {
}
