package com.sioux.andre.messias.restaurant.dto.mapper;

import com.sioux.andre.messias.restaurant.domain.RestaurantDomain;
import com.sioux.andre.messias.restaurant.dto.RestaurantDTO;

public class RestaurantMapper {

 public RestaurantDomain toDomain(RestaurantDTO dto) {

  RestaurantDomain restaurantDomain = RestaurantDomain.builder().restaurant(dto.getName()).build();

  return restaurantDomain;
 }

 public RestaurantDTO toRepresentationModel(RestaurantDomain domain) {
  RestaurantDTO restaurantDTO = RestaurantDTO.builder().name(domain.getRestaurant()).build();
  return restaurantDTO;
 }

}