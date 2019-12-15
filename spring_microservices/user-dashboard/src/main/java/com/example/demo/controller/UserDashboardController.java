package com.example.demo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Users;

@RestController
@RequestMapping("/api")
public class UserDashboardController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/dashboard/peers")
	public Collection<Users> findPeers() {

		String url = "http://b8java12.iiht.tech:8050/user-service/api/users";
		System.out.println("URL" + url);

		@SuppressWarnings("unchecked")
		List<Users> list = restTemplate.getForObject(url, List.class);

		System.out.println("RESPONSE " + list);

		return list;

	}

	

}
