package com.springboot.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.springboot.demo.model.Photo;


// the CrudRepository creates SQL statements automatically
public interface PhotoRepo extends CrudRepository<Photo, Integer>{
  
}
