package com.example.demo;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;

@RefreshScope
@RestController
@RequestMapping("/api")
public class UserServiceController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<Users> findAll() {
		return userRepository.findAll();
	}
	@PostMapping("/users")
	public Users save(@RequestBody Users user)
	{
		return userRepository.save(user);
	}

}
