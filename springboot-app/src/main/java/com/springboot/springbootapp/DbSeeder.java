package com.springboot.springbootapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner {
	private HotelRepository hotelRepository;
	
	public DbSeeder(HotelRepository hotelRepository) {
		this.hotelRepository=hotelRepository;
	}
	@Override
	public void run(String... strings) throws Exception {
		Hotel Anish = new Hotel("Anish-Hotel", 180, new Address("Butwal", "Rupandehi"),
				Arrays.asList(new Review("Mansun", 8, true), new Review("Mansun", 8, false)));
		Hotel Radha = new Hotel("Radha-Hotel", 180, new Address("Pittsburgh", "Pennsylvania"),
				Arrays.asList(new Review("Mansun", 8, true), new Review("Mansuna", 9,false)));
		Hotel Prakash = new Hotel("Prakash-Hotel", 180, new Address("Lagankhel", "Bhaktapur"),
				Arrays.asList(new Review("Mansunu", 5, true)));
		Hotel Subash = new Hotel("Subash-Hotel", 180, new Address("Tulsipur", "Dang"),
				Arrays.asList(new Review("Mansunee", 7, true), new Review("Mansune", 8, true)));
		
		//drop all hotels
		this.hotelRepository.deleteAll();
		
		//add our hotels to the database
		List<Hotel>hotels=Arrays.asList(Anish,Radha,Prakash,Subash);
		this.hotelRepository.saveAll(hotels);
	}
}
