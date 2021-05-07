package ru.stqa.pft.addressbook.model;

public class ContactData {
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
