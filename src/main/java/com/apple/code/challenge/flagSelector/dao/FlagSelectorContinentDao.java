package com.apple.code.challenge.flagSelector.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.apple.code.challenge.flagSelector.Model.Continent;
import com.apple.code.challenge.flagSelector.Model.Country;

@Component
public interface FlagSelectorContinentDao {
	
	List<Continent> getContinentsDatafromDB();
	List<Country> getAllCountriesByContinent(String continentName);
	String getCountryFlag(String countryName);
	

}
