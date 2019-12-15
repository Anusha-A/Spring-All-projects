package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Album;


public interface AlbumService {
	
	public List<Album> getAllAbulms();
	public Album save(Album theAlbum);
	public Album update(Album theAlbum);
	public Optional<Album>  fingById(int theId);
	public void delete(int theId);

}
