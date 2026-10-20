package com.vikram.Team_expence_Manager.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(@NotBlank(message = "name is requried")
                          String name,
                          @NotBlank(message = "Email is requried")
                          @Email(message = "Invalid email foramate")
                          @Email(message = "Invalid email formate")
                          String email) {

}
