package com.nurbnb.reservation.core.ports.driven;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReservationDto {
    private long reservationId;
    private String reservationNumber;
    private LocalDate createdAt;
	private LocalDate startDate;
	private LocalDate endDate;
    private String status;
    private String paymentType;
}
