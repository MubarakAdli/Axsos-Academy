package com.axsos.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.dojosninjas.models.Dojo;
import com.axsos.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {

	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> getAllDojos() {
		return  dojoRepository.findAll();
	}
	
	public Dojo findDojoById(Long id) {
		Optional<Dojo> findDojo = dojoRepository.findById(id);
		if (findDojo.isPresent()) {
			return findDojo.get();
		} else {
			return null;
		}
	}

	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
}
