package com.charan.lookify.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.charan.lookify.models.Song;

@Repository
public interface SongRepo extends CrudRepository<Song, Long> {
	
	List<Song> findAll();
	
	// Search bar functionality, find by artist
	List<Song> findByArtistContaining(String artist);
	
	// Custom query to get top 10 songs
	@Query(value="SELECT * FROM songs ORDER BY rating DESC LIMIT 10", nativeQuery=true)
	List<Song> topSongs();
 	
}
