package com.nurbnb.reservation.core.internal.cleanarch.domain.reservations;

import java.util.Optional;

public interface ReservationRepository {

    Optional<Reservation> find(ReservationNumber reservationNumber);

    Reservation findRequired(ReservationNumber reservationNumber);

    void add(Reservation reservation);

    void update(Reservation reservation);

    ReservationId nextReservationId();

    ReservationNumber nextReservationNumber();
}
