package com.sabrine.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabrine.dojoandninjas.models.Ninja;
import com.sabrine.dojoandninjas.repositories.NinjaRepository;

@Service

public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepo;
	
//	Read all
	
	public List<Ninja> findAll(){
		return ninjaRepo.findAll();
	}
//create
	
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
//	read one
	public Ninja findNinja(Long id) {
		Optional<Ninja> mybeNinja= ninjaRepo.findById(id);
		if(mybeNinja.isPresent()) {
			return mybeNinja.get();
		}
		else {
			return null;
		}
	}
//	update
	
	public Ninja updateNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
//	delete
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
}
