package com.nurbnb.reservation.core.internal.cleanarch.domain.reservations;

import com.nurbnb.reservation.core.internal.cleanarch.domain.common.events.BaseDomainEvent;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReservationOpened extends BaseDomainEvent {
    private ReservationId reservationId;
    private ReservationHolderName reservationHolderName;

    public ReservationOpened(LocalDateTime timestamp, ReservationId reservationId, ReservationHolderName reservationHolderName) {
        super(timestamp);
        this.reservationId = reservationId;
        this.reservationHolderName = reservationHolderName;
    }
}
