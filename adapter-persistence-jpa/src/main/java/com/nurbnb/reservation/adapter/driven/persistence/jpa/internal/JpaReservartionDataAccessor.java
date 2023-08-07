package com.nurbnb.reservation.adapter.driven.persistence.jpa.internal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaReservartionDataAccessor extends CrudRepository<ReservationRecord, Long> {
    Optional<ReservationRecord> findByReservationNumber(String reservationNumber);
}
