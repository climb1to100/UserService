package com.lcwd.user.service.external.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lcwd.user.service.entities.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	ResponseEntity<List<Rating>> getAllHotels();

	@GetMapping("/ratings/id")
	ResponseEntity<Rating> getHotelById(@RequestParam("ratingId") ObjectId id);

	@GetMapping("/ratings/by/user")
	ResponseEntity<List<Rating>> getRatingsByUserId(@RequestParam("userId") Long userId);

	@GetMapping("/ratings/by/hotel")
	ResponseEntity<List<Rating>> getRatingsByHotelId(@RequestParam("hotelId") Long hotelId);
}
