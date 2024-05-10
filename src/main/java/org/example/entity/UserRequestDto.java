package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Setter
@Getter
public class UserRequestDto implements Serializable {
  @NotNull
  @Size(min = 1)
  private String name;

  private Integer age;

  public User toUser() {
    return new User(name, age);
  }
}
