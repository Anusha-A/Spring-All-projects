package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Posts;
import com.example.demo.service.PostService;

@RestController
@RequestMapping("/api")
public class PostsController {
	public PostsController(PostService postService) {
		super();
		this.postService = postService;
	}

	private PostService postService;
	
	@RequestMapping("/posts")
	public List<Posts> getAllPosts()
	{
		return postService.getAllPosts();
	
		
	}

}
