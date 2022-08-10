package com.charan.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.charan.languages.models.Language;
import com.charan.languages.repos.LanguageRepository;

@Service
//CRUD HAPPENS HERE
public class LanguageService {
// add repository as dependency (dependency injection)	
	private final LanguageRepository langRepo;

	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}

// FIND ALL	
	public List<Language> allLanguages(){
		return langRepo.findAll();
	}

// 	CREATE
	public Language addLanguage(Language lang) {
		return langRepo.save(lang);
	}
	
// FIND ONE
	public Language findOneLang(Long id) {
		Optional<Language> optionalLang = langRepo.findById(id);
		if(optionalLang.isPresent()) {
			return optionalLang.get();
		} else {
			return null;
		}
	}
	
// DELETE
	public void delete(Long id) {
		langRepo.deleteById(id);
	}

// UPDATE
	public Language editLang(Language lang) {
		return langRepo.save(lang);
	}
	
}
