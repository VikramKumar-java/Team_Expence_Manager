package com.vikram.Team_expence_Manager.Exceptions;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timetamp,
        int status,
        String error,
        String message,
        String path
) {
}
