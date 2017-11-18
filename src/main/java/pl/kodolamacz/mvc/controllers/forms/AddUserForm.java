package pl.kodolamacz.mvc.controllers.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by acacko on 18.11.17
 */
public class AddUserForm {

  @Email
  private String email;

  @NotBlank
  @Size(min = 8)
  private String password;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}