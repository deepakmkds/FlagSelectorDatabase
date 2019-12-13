package com.apple.code.challenge.flagSelector.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "country")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int country_id;

	
	@ManyToOne
	@JoinColumn(name = "continent_name")
	private Continent continent;

	@Column
	private String country_name;

	@Column
	private String country_flag;

	public Country() {
	}

	

	public Country(int country_id, Continent continent, @NotNull String country_name, @NotNull String country_flag) {
		super();
		this.country_id = country_id;
		this.continent = continent;
		this.country_name = country_name;
		this.country_flag = country_flag;
	}



	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getCountry_flag() {
		return country_flag;
	}

	public void setCountry_flag(String country_flag) {
		this.country_flag = country_flag;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

}
