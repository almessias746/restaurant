package com.sioux.andre.messias.restaurant.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class DemoController {

  @GetMapping("/greet/{name}")
  public String greeting(@PathVariable String name) {
    return "Hi!! " + name;
  }
}