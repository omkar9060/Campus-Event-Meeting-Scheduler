package com.model;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Event {

    private Long id;

    @NotBlank(message = "Title required")
    private String title;

    @NotBlank(message = "Organizer required")
    private String organizer;

    @Future(message = "Date must be future")
    private LocalDateTime dateTime;

    @Min(1)
    private int capacity;
}
