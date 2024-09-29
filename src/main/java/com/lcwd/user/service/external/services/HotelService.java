package com.lcwd.user.service.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.lcwd.user.service.entities.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

	@GetMapping("/hotel/list")
	public ResponseEntity<List<Hotel>> getAllHotels();

	@GetMapping("/hotel/byId")
	public ResponseEntity<Hotel> getHotelById(@RequestParam("hotelId") Long hotelId);

	@PostMapping("/hotel/save")
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel);

	@DeleteMapping("/hotel/delete")
	public ResponseEntity<String> deleteHotel(@RequestParam("hotelId") Long hotelId);
}