package com.apple.code.challenge.flagSelector.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apple.code.challenge.flagSelector.Exception.ResourceNotFoundException;
import com.apple.code.challenge.flagSelector.Model.Continent;
import com.apple.code.challenge.flagSelector.Model.Country;
import com.apple.code.challenge.flagSelector.Service.FlagSelectorContinentService;
import com.apple.code.challenge.flagSelector.Service.Impl.FlagSelectorService;

@RestController
@RequestMapping("/flagselector")
public class FlagSelectorDBController {

	@Autowired
	private FlagSelectorContinentService flagSelectorContinentService;

	public FlagSelectorDBController(FlagSelectorService flagSelectorService) {
		this.flagSelectorContinentService = flagSelectorContinentService;
	}


	@GetMapping("/continents")
	public List<Continent> getContinentDatafromDB() throws ResourceNotFoundException {
		List<Continent> continentList = flagSelectorContinentService.getContinentsDatafromDB();
		if (continentList == null || continentList.isEmpty()) {
			throw new ResourceNotFoundException("NO_DATA_FOUND");
		} else {
			return continentList;
		}
	}

	@GetMapping("/getByContinent/{continentName}")
	public List<Country> getByContinent(@PathVariable String continentName) throws ResourceNotFoundException {
		List<Country> countryList = flagSelectorContinentService.getAllCountriesByContinent(continentName);
		if (countryList == null || countryList.isEmpty()) {
			throw new ResourceNotFoundException("CONTINENT_NOT_FOUND");
		} else {
			return countryList;
		}
	}

	@GetMapping("/getByCountry/{continentName}/{countryName}")
	public String getByCountry(@PathVariable String continentName, @PathVariable String countryName)
			throws ResourceNotFoundException {
		String flag = null;
		flag = flagSelectorContinentService.getCountryFlag(countryName);
		if (flag == null || flag.equalsIgnoreCase("")) {
			throw new ResourceNotFoundException("COUNTRY_NOT_FOUND");
		} else {
			return flag;
		}
	}

}
