package com.example.reviews.controller;

import com.example.reviews.model.Product;
import com.example.reviews.model.Review;
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

  /**
     --entityDataFetcher [maps representations to entity stubs]---------------------------------
       In
         representation = {LinkedHashMap@9921}  size = 2
         "id" -> "2"
         "__typename" -> "Product"
       Out
         productStub = {Product@9923} "Product[id=2]"
         id = "2"

   --@SchemaMapping(typeName="Product", field="reviews")--------------------------
     In
         productStub = {Product@9923} "Product[id=2]"
         id = "2"
     Out
       reviews = {ImmutableCollections$List12@10130}  size = 2
         0 = {Review@10133} "Review[id=2, text=Very cramped :( Do not recommend., starRating=2]"
           id = "2"
           text = "Very cramped :( Do not recommend."
           starRating = {Integer@10144} 2
         1 = {Review@10134} "Review[id=2, text=Got me to the Moon!, starRating=4]"
           id = "2"
           text = "Got me to the Moon!"
           starRating = {Integer@10146} 4
     -------------------------------------------------
   */
  @SchemaMapping(typeName="Product", field="reviews")
  public List<Review> reviews(Product productStub) {
    List<Review> reviews = getReviews(productStub);
    return reviews;
  }
  private List<Review> getReviews(Product productStub) {
    return REVIEWS.getOrDefault(productStub.id(), Collections.emptyList());
  }

  @QueryMapping
  public List<Review> review(@Argument String id) {
    return REVIEWS.getOrDefault(id, Collections.emptyList());
  }

}
