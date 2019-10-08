package com.xjl.domain;

import javax.persistence.*;

@Entity
@Table(name = "acg")
public class Cos {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String imgSrc;
  private String title;
  private String category;
  private String uid;
  private String name;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getImgSrc() {
    return imgSrc;
  }

  public void setImgSrc(String imgSrc) {
    this.imgSrc = imgSrc;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }


  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Cos{" +
            "id=" + id +
            ", imgSrc='" + imgSrc + '\'' +
            ", title='" + title + '\'' +
            ", category='" + category + '\'' +
            ", uid='" + uid + '\'' +
            ", name='" + name + '\'' +
            '}';
  }
}
