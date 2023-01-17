package com.springboot.demo.service;


import org.hibernate.validator.internal.util.logging.Log_.logger;
import org.springframework.stereotype.Service;

import com.springboot.demo.model.Photo;
import com.springboot.demo.repository.PhotoRepo;


@Service
public class PhotosService {
  
  private final PhotoRepo photosRepo;

  public PhotosService(PhotoRepo photosRepo) {
    this.photosRepo = photosRepo;
  }


  public Iterable<Photo> get() {
    return photosRepo.findAll();
  }

  public Photo get(Integer id) {
    return photosRepo.findById(id).orElse(null);
  }

  public void remove(Integer id) {
    photosRepo.deleteById(id);
  }

  public Photo save(String fileName, String contentType, byte[] data) {
    Photo photo = new Photo();
    photo.setContentType(contentType);
    photo.setFileName(fileName);
    photo.setData(data);
    photosRepo.save(photo);
    return photo;
  }
}
