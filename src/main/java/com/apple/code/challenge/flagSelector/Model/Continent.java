package com.apple.code.challenge.flagSelector.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "continent")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Continent {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer continent_id;

	@Column
	private String continent_name;

	@OneToMany(mappedBy = "continent") // defines the mapping to be present in the countries table
	private List<Country> countries = new ArrayList<>();

	public Continent() {

	}

	public Continent(Integer continent_id, String continent_name, List<Country> countries) {
		super();
		this.continent_id = continent_id;
		this.continent_name = continent_name;
		this.countries = countries;
	}

	public Integer getContinent_id() {
		return continent_id;
	}

	public void setContinent_id(Integer continent_id) {
		this.continent_id = continent_id;
	}

	public String getContinent_name() {
		return continent_name;
	}

	public void setContinent_name(String continent_name) {
		this.continent_name = continent_name;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

}
