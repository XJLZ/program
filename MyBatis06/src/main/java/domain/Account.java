package domain;


import java.util.List;

public class Account {

  private Integer id;
  private Integer uid;
  private double money;

  private User user;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }

  @Override
  public String toString() {
    return "Account{" +
            "id=" + id +
            ", uid=" + uid +
            ", money=" + money +
            '}';
  }
}
