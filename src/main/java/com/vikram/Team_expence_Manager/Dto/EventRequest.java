package com.vikram.Team_expence_Manager.Dto;

import jakarta.validation.constraints.NotBlank;

public record EventRequest(@NotBlank(message = "Event name is requried") String eventName,
                           @NotBlank(message = "Location is requried") String location) {

}
