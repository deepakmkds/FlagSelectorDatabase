package com.apple.code.challenge.flagSelector.Service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apple.code.challenge.flagSelector.Model.Continent;
import com.apple.code.challenge.flagSelector.Model.Country;
import com.apple.code.challenge.flagSelector.Service.FlagSelectorContinentService;
import com.apple.code.challenge.flagSelector.dao.FlagSelectorContinentDao;

@Component
@Transactional
public class FlagSelectorContinentServiceImpl implements FlagSelectorContinentService {
	
	@Autowired
	private FlagSelectorContinentDao flagSelectorContinentDao;

	@Override
	public List<Continent> getContinentsDatafromDB() {
		// TODO Auto-generated method stub
		return flagSelectorContinentDao.getContinentsDatafromDB();
	}

	@Override
	public List<Country> getAllCountriesByContinent(String continentName) {
		return flagSelectorContinentDao.getAllCountriesByContinent(continentName);
	}

	@Override
	public String getCountryFlag(String countryName) {
		return flagSelectorContinentDao.getCountryFlag(countryName);
	}



	

	

}
