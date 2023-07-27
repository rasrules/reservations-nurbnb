package com.nurbnb.reservation.core.ports.driver.accounts.viewaccount;

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
