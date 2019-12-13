package com.apple.code.challenge.flagSelector.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apple.code.challenge.flagSelector.Model.Continent;
import com.apple.code.challenge.flagSelector.Model.Country;
import com.apple.code.challenge.flagSelector.dao.FlagSelectorContinentDao;

@Component
@Repository
public class FlagSelectorContinentDaoImpl implements FlagSelectorContinentDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Continent> getContinentsDatafromDB() {
		Query theQuery = entityManager.createQuery("from continent");
		List<Continent> continents = theQuery.getResultList();
		return continents;
	}

	@Override
	public List<Country> getAllCountriesByContinent(String continentName) {
		Query theQuery = entityManager.createQuery("from country");
		theQuery.setParameter("continent_name", continentName);
		List<Country> countries = theQuery.getResultList();
		return countries;
	}

	@Override
	public String getCountryFlag(String countryName) {
		Query theQuery = entityManager.createQuery("from country");
		theQuery.setParameter("country_name", countryName);
		String flag = theQuery.getResultList().toString();
		return flag;
	}

}
