package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.ImageRepository;
import com.example.demo.entity.Image;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {
	
	private ImageRepository imageRepository;

	@Override
	public List<Image> getAllImages() {
		// TODO Auto-generated method stub
		return imageRepository.findAll();
	}

	public ImageServiceImpl(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}

	@Override
	@Transactional
	public Image save(Image theImage) {
		return imageRepository.save(theImage);

	}

	@Override
	public Image update(Image theImage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image fingById(int theId) {
		
		return null;
	}

	@Override
	@Transactional
	public void delete(int theId) {
		imageRepository.deleteById(theId);

	}

}
