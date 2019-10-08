package com.xjl.domain;


public class TxAccount {

  private long id;
  private String name;
  private double money;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }

  @Override
  public String toString() {
    return "TxAccount{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", money=" + money +
            '}';
  }
}
