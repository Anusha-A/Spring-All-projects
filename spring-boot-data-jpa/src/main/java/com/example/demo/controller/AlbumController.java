package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Album;

import com.example.demo.service.AlbumService;

@RestController
@RequestMapping("/api")
public class AlbumController {
	private AlbumService albumService;

	public AlbumController(AlbumService albumService) {
		super();
		this.albumService = albumService;
	}
	@GetMapping("/albums")
	public List<Album> getAllEmployee(){
		return albumService.getAllAbulms();
	}
	
	@GetMapping("/albums/id/{theId}")
	public Optional<Album> GetById(int theId)
	{
		return albumService.fingById(theId);
	}
	
	@PostMapping("/albums")
	public Album save(@RequestBody Album theAlbum)
	{
		return albumService.save(theAlbum);
	}
	
	@DeleteMapping("/albums/{theId}")
	public void delete(@PathVariable int theId)
	{
		albumService.delete(theId);
	}
}
