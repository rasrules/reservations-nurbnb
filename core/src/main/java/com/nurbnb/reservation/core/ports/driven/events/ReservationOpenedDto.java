package com.nurbnb.reservation.core.ports.driven.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationOpenedDto implements EventDto {
    private LocalDateTime timestamp;
    private long accountId;
    private String firstName;
    private String lastName;
    private int balance;
}
