package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Image;
import com.example.demo.service.ImageService;


@RestController
@RequestMapping("/api")
public class ImageController {
	private ImageService imageService;

	public ImageController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@GetMapping("/images")
	public List<Image> getAllImages(){
		return imageService.getAllImages();
	}
	
	@PostMapping("/images")
	public Image save(@RequestBody Image theImage)
	{
		return imageService.save(theImage);
	}
	

}
