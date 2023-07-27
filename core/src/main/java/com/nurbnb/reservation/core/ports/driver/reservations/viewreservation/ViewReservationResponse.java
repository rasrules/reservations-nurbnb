package com.nurbnb.reservation.core.ports.driver.reservations.viewreservation;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class ViewReservationResponse {
    private String reservationNumber;
    private String fullName;
}
