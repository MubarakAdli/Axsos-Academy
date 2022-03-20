package com.axsos.dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axsos.dojosninjas.models.Ninja;
import com.axsos.dojosninjas.repositories.NinjaRepository;
@Service
public class NinjaService {

	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository=ninjaRepository;
	}
	
	public List<Ninja> getAllNinjas(){
		return ninjaRepository.findAll();
	}
	
	public Ninja create(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
}
