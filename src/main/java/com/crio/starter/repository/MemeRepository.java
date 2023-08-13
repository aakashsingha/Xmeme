package com.crio.starter.repository;

import com.crio.starter.data.MemeEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeRepository extends MongoRepository<MemeEntity,Integer> {
    
    
}
