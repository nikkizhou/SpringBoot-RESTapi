package com.springboot.demo;


import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;

@RestController
public class DownloadController {

  @GetMapping("/photos/{id}")
  public ResponseEntity<byte[]> download(@PathVariable String id) {
    byte data[];
     HttpHeaders headers = new HttpHeaders(null);
    return new ResponseEntity<>(data, headers, HttpStatus.OK);
  }
  
}
