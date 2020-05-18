package com.sioux.andre.messias.restaurant.service;

import java.util.List;

import com.sioux.andre.messias.restaurant.dto.RestaurantDTO;
import com.sioux.andre.messias.restaurant.repository.PublicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicService {

 @Autowired
 PublicRepository publicRepository;

 public List<RestaurantDTO> findRestaurant(String name){
  return null;
 }


}