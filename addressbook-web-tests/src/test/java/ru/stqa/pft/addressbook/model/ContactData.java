package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String id;
  private final String name;
  private final String lastname;
  private final String nickname;
  private final String company;
  private final String address;
  private final String homephone;
  private final String mobile;
  private final String email;
  private String group;
  private boolean creation;


  public ContactData(String name, String lastname, String nickname, String company, String address, String homephone, String mobile, String email, String group) {
    this.id = null;
    this.name = name;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.homephone = homephone;
    this.mobile = mobile;
    this.email = email;
    this.group = group;
  }

  public ContactData(String id, String name, String lastname, String nickname, String company, String address, String homephone, String mobile, String email, String group) {
    this.id = id;
    this.name = name;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.homephone = homephone;
    this.mobile = mobile;
    this.email = email;
    this.group = group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, lastname);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomephone() {
    return homephone;
  }

  public String getMobile() {
    return mobile;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }

}
