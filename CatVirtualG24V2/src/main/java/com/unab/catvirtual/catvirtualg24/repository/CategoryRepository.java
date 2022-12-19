package com.unab.catvirtual.catvirtualg24.repository;

import com.unab.catvirtual.catvirtualg24.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,String> {
}
