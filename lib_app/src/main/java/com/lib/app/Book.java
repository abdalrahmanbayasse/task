package com.lib.app;

import java.util.UUID;

public class Book {
  String id, title, author, description, categories;
  int quantity;
  boolean booked;

  public Book(String title, String author, String description, String categories, int quantity) {
    this.id = UUID.randomUUID().toString();
    this.title = title;
    this.author = author;
    this.description = description;
    this.categories = categories;
    this.quantity = quantity;

  }

}
