package com.example.backend.Repository;

import com.example.backend.Model.Model;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DataRepository extends MongoRepository<Model, ObjectId> {

  @Query("{ '$and': ["
         + "{ 'topic': { '$regex': ?0, '$options': 'i' } },"
         + "{ 'endYear': ?1 },"
         + "{ 'sector': { '$regex': ?2, '$options': 'i' } },"
         + "{ 'region': { '$regex': ?3, '$options': 'i' } },"
         + "{ 'PEST': { '$regex': ?4, '$options': 'i' } },"
         + "{ 'source': { '$regex': ?5, '$options': 'i' } },"
         + "{ 'country': { '$regex': ?6, '$options': 'i' } },"
         + "]}")
  List<Model>
  findFilteredData(String topic, Integer endYear, String sector, String region,
                   String PEST, String source, String country);
}
