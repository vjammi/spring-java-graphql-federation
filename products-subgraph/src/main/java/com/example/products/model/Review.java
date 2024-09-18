package com.example.products.model;

public record Review(String id, String text, Integer starRating) {

  public Review(String id, Integer starRating) {
    this(id, null, starRating);
  }
}
