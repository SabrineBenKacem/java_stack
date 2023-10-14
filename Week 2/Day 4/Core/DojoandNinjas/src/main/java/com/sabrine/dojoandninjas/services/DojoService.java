package com.sabrine.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabrine.dojoandninjas.models.Dojo;
import com.sabrine.dojoandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepository dojoRepo;
	
//	read all
	public List<Dojo> findAll(){
		return dojoRepo.findAll();
	}
//	create
	
	public Dojo createDojo(Dojo d){
		return dojoRepo.save(d);
	}
//find one
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> mybeDojo = dojoRepo.findById(id);
		if(mybeDojo.isPresent()) {
			return mybeDojo.get();
		}
		else {
			return null;
		}
	}
//	update
	public Dojo updateDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
//	delete
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
}
