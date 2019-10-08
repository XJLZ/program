package com.domain;


public class Books {
    private Integer bookId;
    private String bookName;
    private String bookAuthor;
    private String bookPress;
    private String bookPressTime;
    private double price;
    private String bookPic;
    private Integer bookType;
    private Integer status;
    private String pic;

  public Integer getBookId() {
    return bookId;
  }

  public void setBookId(Integer bookId) {
    this.bookId = bookId;
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public String getBookAuthor() {
    return bookAuthor;
  }

  public void setBookAuthor(String bookAuthor) {
    this.bookAuthor = bookAuthor;
  }

  public String getBookPress() {
    return bookPress;
  }

  public void setBookPress(String bookPress) {
    this.bookPress = bookPress;
  }

  public String getBookPressTime() {
    return bookPressTime;
  }

  public void setBookPressTime(String bookPressTime) {
    this.bookPressTime = bookPressTime;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getBookPic() {
    return bookPic;
  }

  public void setBookPic(String bookPic) {
    this.bookPic = bookPic;
  }

  public Integer getBookType() {
    return bookType;
  }

  public void setBookType(Integer bookType) {
    this.bookType = bookType;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getPic() {
    return pic;
  }

  public void setPic(String pic) {
    this.pic = pic;
  }

  @Override
  public String toString() {
    return "Books{" +
            "bookId=" + bookId +
            ", bookName='" + bookName + '\'' +
            ", bookAuthor='" + bookAuthor + '\'' +
            ", bookPress='" + bookPress + '\'' +
            ", bookPressTime='" + bookPressTime + '\'' +
            ", price=" + price +
            ", bookPic='" + bookPic + '\'' +
            ", bookType=" + bookType +
            ", status=" + status +
            ", pic='" + pic + '\'' +
            '}';
  }
}