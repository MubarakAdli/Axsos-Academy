package com.axsos.lookify.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.lookify.models.Song;


@Repository
public interface songRepository extends CrudRepository<Song,Long>{
	List<Song> findAll();
	List<Song> findTop10ByOrderByRateDesc();
	List<Song> findByArtistContaining(String name);
	@Query(value="SELECT * FROM songs WHERE artist=?1",nativeQuery=true)
	List<Song> findSongsFromArtist(String name);
	
}
