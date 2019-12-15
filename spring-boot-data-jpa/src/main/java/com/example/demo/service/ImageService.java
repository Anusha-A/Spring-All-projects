package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Image;

public interface ImageService {
	public List<Image> getAllImages();
	public Image save(Image theImage);
	public Image update(Image theImage);
	public Image fingById(int theId);
	public void delete(int theId);

}
