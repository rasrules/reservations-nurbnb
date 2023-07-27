package com.nurbnb.reservation.core.ports.driven;

import java.util.Optional;

public interface ReservationStorage {
    Optional<ReservationDto> find(String reservationNumber);

    void add(ReservationDto reservation);

    void update(ReservationDto reservation);
}
