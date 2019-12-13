package com.apple.code.challenge.flagSelector.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apple.code.challenge.flagSelector.Model.Continent;
import com.apple.code.challenge.flagSelector.dao.CountryRepository;

@Service
public class FlagSelectorService {
	
	private CountryRepository countryRepository;

	public FlagSelectorService(CountryRepository countryRepository) {
		super();
		this.countryRepository = countryRepository;
	}
	
	 public Iterable<Continent> list() {
	        return countryRepository.findAll();
	    }

	
	public Continent save(Continent continent) {
        return countryRepository.save(continent);
    }
	
	  public void save(List<Continent> continents) {
		  countryRepository.saveAll(continents);
	    }
	  
	  
}
