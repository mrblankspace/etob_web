package cn.swpu.beans;


import javax.validation.constraints.NotNull;

public class Message {

  private String email;
//  @NotNull
  private String username;
  private long id;
//  @NotNull
  private String message;
  private String date;


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String userName) {
    this.username = userName;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
