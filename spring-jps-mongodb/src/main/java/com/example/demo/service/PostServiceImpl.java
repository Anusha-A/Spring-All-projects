package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Posts;
import com.example.demo.repository.PostsRepository;

@Service
public class PostServiceImpl implements PostService {
	private PostsRepository postsrepository;

	public PostServiceImpl(PostsRepository postsrepository) {
		super();
		this.postsrepository = postsrepository;
	}

	@Override
	public List<Posts> getAllPosts() {
		
		return postsrepository.findAll();
	}

}
