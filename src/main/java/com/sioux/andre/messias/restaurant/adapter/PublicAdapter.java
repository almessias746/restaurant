package com.sioux.andre.messias.restaurant.adapter;

import java.util.List;

import com.sioux.andre.messias.restaurant.dto.RestaurantDTO;
import com.sioux.andre.messias.restaurant.service.PublicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublicAdapter {

 @Autowired
PublicService publicService;

public List<RestaurantDTO> findRestaurant(String name){
 return this.publicService.findRestaurant(name);
}


}