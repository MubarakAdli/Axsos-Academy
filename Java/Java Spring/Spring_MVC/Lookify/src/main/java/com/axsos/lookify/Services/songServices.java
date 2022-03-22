package com.axsos.lookify.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.lookify.Repository.songRepository;
import com.axsos.lookify.models.Song;

@Service
public class songServices {
	private final songRepository SongRepository ;
    
    public songServices (songRepository SongRepository) {
        this.SongRepository = SongRepository;
    }
    // creates a book
    public Song createSong(Song b) {
    	return SongRepository.save(b);
    }
    // retrieves a book
    public Song findSong(Long id) {
        Optional<Song> optionalSong = SongRepository.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }
    public void delete(Long id) {
    	Optional<Song> song = SongRepository.findById(id);
    	if (song != null) {
    		SongRepository.deleteById(id);}
    	
    	}
	public List<Song> allSongs() {
		
		return SongRepository.findAll();
	}
	
	public List<Song> findTopTen(){
		return SongRepository.findTop10ByOrderByRateDesc();
	}
	

	public List<Song> searchArtist(String name) {
		return SongRepository.findSongsFromArtist(name);
	}
}
