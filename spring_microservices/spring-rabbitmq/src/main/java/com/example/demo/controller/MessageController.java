package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Employee;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	@GetMapping(value = "/form")
	public String viewFrom() {
		return "message/send_message";
	}
}
