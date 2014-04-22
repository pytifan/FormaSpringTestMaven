package org.region.forms.osvoenie.spring.controller;

import java.io.Serializable;

/** POJO used by the Letter example. */
public class Recipient implements Serializable {

  private String name;
  private String address;
  private String postCode;
  private String city;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
