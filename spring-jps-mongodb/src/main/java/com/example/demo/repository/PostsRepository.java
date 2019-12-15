package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Posts;

@Repository
public interface PostsRepository extends MongoRepository<Posts, String> {


}
