package com.springboot.demo.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.demo.model.Photo;
import com.springboot.demo.service.PhotosService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;

@RestController
public class DownloadController {
  private final PhotosService photoService;

  public DownloadController(PhotosService photoService) {
    this.photoService = photoService;
  }

  @GetMapping("/download/{id}")
  public ResponseEntity<byte[]> download(@PathVariable Integer id) {
    Photo photo = photoService.get(id);
    if (photo == null)
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    
    byte data[] = photo.getData();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.valueOf(photo.getContentType()));

    // the attachment here is telling browser to download the pic directly
    ContentDisposition build = ContentDisposition.builder("attachment")
      .filename(photo.getFileName())
      .build();
    headers.setContentDisposition(build);

    return new ResponseEntity<>(data, headers, HttpStatus.OK);
  }
  
}
