package com.springboot.demo.web;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.demo.model.Photo;
import com.springboot.demo.service.PhotosService;


@RestController
public class DemoController {

  // if we have @autowired here, then it does the constructor injection automatically for us.
  private final PhotosService photoService;
  public DemoController(PhotosService photoService) {
    this.photoService = photoService;
  }


  @GetMapping("/")
  public String hello() {
    return "Hello World";
  }
  
  @GetMapping("/photos")
  public Iterable<Photo> get() {
    return photoService.get();
  }

  @GetMapping("/photos/{id}")
  public Photo get(@PathVariable Integer id) {
    Photo photo = photoService.get(id);
    if (photo == null)
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    return photo;
  }
  
  @DeleteMapping("/photos/{id}")
  public void delete(@PathVariable Integer id) {
    photoService.remove(id);
  }

  @PostMapping("/photos")
  public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
    return photoService.save(file.getOriginalFilename(), file.getContentType(), (file.getBytes()));
  }
}
