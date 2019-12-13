package com.apple.code.challenge.flagSelector.dao;

import org.springframework.data.repository.CrudRepository;

import com.apple.code.challenge.flagSelector.Model.Continent;

public interface CountryRepository extends CrudRepository<Continent, Long>{

}
