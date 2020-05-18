package com.sioux.andre.messias.restaurant.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.sioux.andre.messias.restaurant.adapter.PublicAdapter;
import com.sioux.andre.messias.restaurant.dto.RestaurantDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path="/api/v1/public")
public class PublicController {

  @Autowired
  private PublicAdapter publicAdapter;

  @GetMapping("/search")
  public List<RestaurantDTO> string(
    @PathVariable String name
    ) {
    return this.publicAdapter.findRestaurant(name);
  }


}