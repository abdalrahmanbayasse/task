package com.lib.app;

import java.util.UUID;

public class Member {
  String id, name, email, address, phone;

  public Member(String name, String email, String address, String phone) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.email= email; 
    this.address = address;
    this.phone = phone;

  }

}
