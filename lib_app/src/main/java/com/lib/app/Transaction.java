package com.lib.app;

import java.util.Date;
import java.util.UUID;

public class Transaction {
  String id, member_id, book_id;
  int status;
  Date date;

  public Transaction(String member_id, String book_id, int status) {

    this.id = UUID.randomUUID().toString();
    this.member_id = member_id;
    this.book_id = book_id;
    this.status = status;
    this.date = new Date();

  }

}
