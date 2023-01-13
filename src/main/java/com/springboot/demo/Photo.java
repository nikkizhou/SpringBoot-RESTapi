package com.springboot.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotEmpty;

public class Photo {
  private String id;
  @NotEmpty
  private String fileName;

  @JsonIgnore
  private byte[] data;


  public Photo() {
  }

  public Photo(String id, String fileName) {
    this.id = id;
    this.fileName = fileName;
  }

  public byte[] getData() {
    return this.data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }




  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFileName() {
    return this.fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }
  
  
}