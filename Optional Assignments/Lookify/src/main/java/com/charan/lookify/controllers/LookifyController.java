package com.charan.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.charan.lookify.models.Song;
import com.charan.lookify.services.SongService;

@Controller
public class LookifyController {

	@Autowired
	private SongService songServ;

	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}

	@GetMapping("/all/songs")
	public String allSongs(Model model) {
		List<Song> allSongs = songServ.allSongs();
		model.addAttribute("allSongs", allSongs);

		return "allSongs.jsp";
	}

	@GetMapping("/new/song")
	public String newSong(@ModelAttribute("newSong") Song newSong) {
		return "addSong.jsp";
	}

	@PostMapping("/new/song")
	public String addNewSong(@Valid @ModelAttribute("newSong") Song newSong, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "addSong.jsp";
		} else {
			songServ.createSong(newSong);
			return "redirect:/all/songs";
		}

	}

	@GetMapping("/song/{id}")
	public String oneSong(@PathVariable("id") Long id, Model model) {
		
		Song oneSong = songServ.findSong(id);
		model.addAttribute("oneSong", oneSong);
		
		return "oneSong.jsp";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		songServ.deleteSong(id);
		return "redirect:/all/songs";
	}
	
	@GetMapping("/top/songs")
	public String topSongs(Model model) {
		
		List<Song> topSongs = songServ.topSongs();
		model.addAttribute("topSongs", topSongs);
		
		return "topSongs.jsp";
	}
	
	@PostMapping("/search")
	public String search(@RequestParam("artist") String artist, Model model) {
		
		model.addAttribute("artist", artist);
		
		List<Song> searched = songServ.findByArtist(artist);
		model.addAttribute("searched", searched);
		
		return "search.jsp";
	}
}
