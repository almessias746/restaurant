package com.sioux.andre.messias.restaurant.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
  
  LocalDateTime timeStamp;
  Integer httpStatus;
  String messageError;
  String message;
  String messageNotTranslated;
  String path;



}