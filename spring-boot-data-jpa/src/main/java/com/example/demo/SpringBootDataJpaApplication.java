package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.demo.dao.AlbumRepository;
import com.example.demo.dao.ImageRepository;
import com.example.demo.entity.Album;
import com.example.demo.entity.Image;
import com.example.demo.service.AlbumService;
import com.example.demo.service.ImageService;



@SpringBootApplication
public class SpringBootDataJpaApplication {
	public SpringBootDataJpaApplication(AlbumRepository albumRepository, ImageRepository imageRepository) {
		super();
		this.albumRepository = albumRepository;
		this.imageRepository = imageRepository;
	}
	private AlbumRepository albumRepository;
	private ImageRepository imageRepository;

	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
		
		
	}
	@Component
	class TestCommandLineRunner implements CommandLineRunner
	{
		
		
		
		@Override
		public void run(String... args) throws Exception{
			List<Image> list=new ArrayList<Image>();
			Album tempAlbum=new Album();
			
			Image tempImage=new Image();
			tempImage.setImageType("png");
			tempImage.setUrl("https://www.image.png.com");
			
			Image tempImage2=new Image();
			tempImage2.setImageType("jpeg");
			tempImage2.setUrl("https://www.image.jpeg.com");
			
			tempAlbum.setAlbumName("BombayDiaries");
			list.add(tempImage);
			list.add(tempImage2);
			tempImage.setAlbum(tempAlbum);
			tempImage2.setAlbum(tempAlbum);
			tempAlbum.setImage(list);
			albumRepository.save(tempAlbum);
			imageRepository.save(tempImage);
			
			
			
			
		}
	}

}
