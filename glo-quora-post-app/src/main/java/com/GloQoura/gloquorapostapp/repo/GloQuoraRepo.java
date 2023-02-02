package com.GloQoura.gloquorapostapp.repo;

import com.GloQoura.gloquorapostapp.model.GloQuoraPost;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GloQuoraRepo extends MongoRepository<GloQuoraPost, Integer> {
}
