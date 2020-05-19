package com.sioux.andre.messias.restaurant.repository;

import com.sioux.andre.messias.restaurant.domain.RestaurantDomain;

import org.springframework.stereotype.Repository;

@Repository
public class PublicRepository {

    public static RestaurantDomain findRestaurant(String name) {
        RestaurantDomain domain = RestaurantDomain.builder().restaurant(name).build();
        return domain;
    }

}