package com.apple.code.challenge.flagSelector;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.apple.code.challenge.flagSelector.Model.Continent;
import com.apple.code.challenge.flagSelector.Service.Impl.FlagSelectorService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class AppleApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(AppleApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(FlagSelectorService countryService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Continent>> typeReference = new TypeReference<List<Continent>>(){};
			//InputStream inputStream = TypeReference.class.getResourceAsStream(name: "/json/continents.json");
			File inputStream = new File("F:\\Apple_Academy\\Apple_code_challenge_DB\\src\\main\\resources\\json\\continents.json");
			
			try {
				List<Continent> continents = mapper.readValue(inputStream,typeReference);
				countryService.save(continents);
				System.out.println("Continents Saved!");
			} catch (IOException e){
				System.out.println("Unable to save Continents: " + e.getMessage());
			}
		};
	}
}
