package com.axsos.lookify.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.lookify.Services.songServices;
import com.axsos.lookify.models.Song;





@Controller
public class SongController {
	 private final songServices SongService;
	 
	    public SongController(songServices SongService){
	        this.SongService = SongService;
	    }
	    
	    @RequestMapping("/")
	    public String main() {
	    	return "main.jsp";
	    }
	    
	    @RequestMapping("/dashboard")
	    public String dashboard(Model model) {
	    	List<Song> songs = SongService.allSongs();
	    	model.addAttribute("songs",songs);
	    	return "dashboard.jsp";
	    }
	    
	    @RequestMapping("/songs/new")
	    public String newForm(@ModelAttribute("songs") Song song) {
	    	return "newForm.jsp";
	    }
	    @PostMapping("/songs/new")
	    public String create(@Valid @ModelAttribute("songs") Song song,BindingResult result) {
	    	if (result.hasErrors()) {
	            return "/newForm.jsp";
	        } else {
	        SongService.createSong(song);
	        return "redirect:/dashboard";
	        }
	    }
	    @RequestMapping("/songs/{id}")
	    public String show(Model model,@PathVariable("id") long id) {
	    	Song song1 = SongService.findSong(id);
	    	model.addAttribute("song",song1);
	    	return "songDetails.jsp";
	    }
	    
	    @RequestMapping("/songs/{id}/delete")
	    public String deleteSong(@PathVariable("id") long id) {
	    	SongService.delete(id);
	    	return "redirect:/dashboard";
	    }
	    @RequestMapping("/topTen")
	    public String topTen(Model model) {
	    	List<Song> songs = SongService.findTopTen();
	    	model.addAttribute("songs",songs);
	    	return "topTen.jsp";
	    }
	    
	    @PostMapping("/search")
	    public String search(Model model,@RequestParam("search") String name) {
	    	List<Song> songs = SongService.searchArtist(name);
	    	model.addAttribute("song",songs);
	    	String artist = name;
	    	model.addAttribute("artist",artist);
	    	return "search.jsp";
	    }
	    
	    }
