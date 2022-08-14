package com.charan.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charan.lookify.models.Song;
import com.charan.lookify.repos.SongRepo;

@Service
public class SongService {

	@Autowired
	private SongRepo songRepo;

	// Read All
	public List<Song> allSongs() {
		return songRepo.findAll();
	}

	// Create
	public Song createSong(Song s) {
		return songRepo.save(s);
	}

	// Read One
	public Song findSong(Long id) {
		Optional<Song> potentialSong = songRepo.findById(id);
		if (potentialSong.isPresent()) {
			return potentialSong.get();
		} else {
			return null;
		}
	}

	// Update
	public Song updateSong(Song s) {
		return songRepo.save(s);
	}

	// Delete
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
	
	// Get Top Songs
	public List<Song> topSongs(){
		return songRepo.topSongs();
	}
	
	// Get By Search Query
	public List<Song> findByArtist(String artist){
		return songRepo.findByArtistContaining(artist);
	}

}
