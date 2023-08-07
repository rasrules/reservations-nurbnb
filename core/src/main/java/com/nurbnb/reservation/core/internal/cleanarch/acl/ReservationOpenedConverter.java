package com.nurbnb.reservation.core.internal.cleanarch.acl;

import com.nurbnb.reservation.core.internal.cleanarch.domain.reservations.ReservationOpened;
import com.nurbnb.reservation.core.ports.driven.events.ReservationOpenedDto;


public class ReservationOpenedConverter {
    public static ReservationOpenedDto fromEvent(ReservationOpened event) {
        return ReservationOpenedDto.builder()
                .timestamp(event.getTimestamp())
                .reservationId(event.getReservationId().toLong())
                .firstName(event.getReservationHolderName().firstName().toString())
                .lastName(event.getReservationHolderName().lastName().toString())
                .build();
    }	
}
