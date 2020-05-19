package com.sioux.andre.messias.restaurant.service;

import java.util.ArrayList;
import java.util.List;

import com.sioux.andre.messias.restaurant.domain.RestaurantDomain;
import com.sioux.andre.messias.restaurant.dto.RestaurantDTO;
import com.sioux.andre.messias.restaurant.dto.mapper.RestaurantMapper;
import com.sioux.andre.messias.restaurant.repository.PublicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicService {

 @Autowired
 PublicRepository publicRepository;

 public List<RestaurantDTO> findRestaurant(String name){
  List<RestaurantDTO> dtos = new ArrayList<RestaurantDTO>();
  RestaurantMapper mapper = new RestaurantMapper();
  RestaurantDomain domain = this.publicRepository.findRestaurant(name);
  dtos.add(mapper.toRepresentationModel(domain));
  return dtos;
 }


}