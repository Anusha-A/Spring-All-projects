package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.AlbumRepository;
import com.example.demo.entity.Album;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
	
	public AlbumServiceImpl(AlbumRepository albumRepository) {
		super();
		this.albumRepository = albumRepository;
	}

	private AlbumRepository albumRepository;

	@Override
	@Transactional
	public List<Album> getAllAbulms() {
		return albumRepository.findAll();

	}

	@Override
	@Transactional
	public Album save(Album theAlbum) {
		return albumRepository.save(theAlbum);

	}

	@Override
	public Album update(Album theAlbum) {
		
		return null;
	}
	
	@Override
	public Optional<Album> fingById(int theId) {
		
		Optional<Album> alb = albumRepository.findById(theId);
		return alb;
	}

	@Override
	@Transactional
	public void delete(int theId) {
		
		
		albumRepository.deleteById(theId);

	}

}
