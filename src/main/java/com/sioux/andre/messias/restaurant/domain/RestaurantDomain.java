package com.sioux.andre.messias.restaurant.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "SIOUX_RESTAURANTE")
public class RestaurantDomain implements Serializable {

 private static final long serialVersionID = 1L;

 @Column(name = "NAME_RESTAURANT", updatable = false, nullable = false, length = 50)
 private String restaurant;

}