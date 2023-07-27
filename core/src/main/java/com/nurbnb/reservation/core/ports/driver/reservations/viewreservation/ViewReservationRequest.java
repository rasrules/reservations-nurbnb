package com.nurbnb.reservation.core.ports.driver.reservations.viewreservation;

import an.awesome.pipelinr.Command;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class ViewReservationRequest implements Command<ViewReservationResponse> {
    private String reservationNumber;
}
