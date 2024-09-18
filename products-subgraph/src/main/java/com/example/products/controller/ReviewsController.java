package com.example.products.controller;

import com.example.products.model.Product;
import com.example.products.model.Review;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class ReviewsController {

  private final Map<String, List<Review>> REVIEWS = Map.of(
    "2", List.of(new Review("2", "Very cramped :( Do not recommend.", 2), new Review("2", "Got me to the Moon!", 4)),
    "3", List.of(new Review("3", 3)),
    "4", List.of(new Review("4", 5), new Review("4", "Reusable!", 5), new Review("4", 5)),
    "5", List.of(new Review("5", "Amazing! Would Fly Again!", 5), new Review("5", 5))
  );

  @SchemaMapping(typeName="Product", field="reviews")
  public List<Review> reviews(Product show) {
    return REVIEWS.getOrDefault(show.id(), Collections.emptyList());
  }

  @QueryMapping
  public List<Review> review(@Argument String id) {
    return REVIEWS.getOrDefault(id, Collections.emptyList());
  }

}
