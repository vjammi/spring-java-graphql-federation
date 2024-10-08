package com.example.products.model;

/**
 * type Product @key(fields: "id") {
 *     id: ID!
 *     name: String!
 *     description: String
 * }
 */
public record Product(String id, String name, String description) {

  public Product(String id, String name) {
    this(id, name, null);
  }

  // +++
  public static final String PRODUCT_TYPE = "Product";

  public Product(String id){
    this(id, null, null);
  }


}
