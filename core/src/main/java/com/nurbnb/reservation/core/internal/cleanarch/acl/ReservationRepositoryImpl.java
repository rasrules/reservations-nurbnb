package com.nurbnb.reservation.core.internal.cleanarch.acl;

import com.nurbnb.reservation.core.internal.cleanarch.domain.reservations.ReservationId;
import com.nurbnb.reservation.core.internal.cleanarch.domain.reservations.ReservationNumber;
import com.nurbnb.reservation.core.internal.cleanarch.domain.reservations.Reservation;
import com.nurbnb.reservation.core.internal.cleanarch.domain.reservations.ReservationRepository;
import com.nurbnb.reservation.core.ports.driven.ReservationIdGenerator;
import com.nurbnb.reservation.core.ports.driven.ReservationNumberGenerator;
import com.nurbnb.reservation.core.ports.driven.ReservationStorage;
import com.nurbnb.reservation.core.ports.driver.exceptions.ValidationException;
import com.nurbnb.reservation.core.ports.driver.exceptions.ValidationMessages;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReservationRepositoryImpl implements ReservationRepository {
    private final ReservationStorage reservationStorage;
    private final ReservationIdGenerator reservationIdGenerator;
    private final ReservationNumberGenerator reservationNumberGenerator;

    public ReservationRepositoryImpl(ReservationStorage reservationStorage, ReservationIdGenerator reservationIdGenerator, ReservationNumberGenerator reservationNumberGenerator) {
        this.reservationStorage = reservationStorage;
        this.reservationIdGenerator = reservationIdGenerator;
        this.reservationNumberGenerator = reservationNumberGenerator;
    }

    @Override
    public Optional<Reservation> find(ReservationNumber reservationNumber) {
        var dto = reservationStorage.find(reservationNumber.toString());

        if(dto.isEmpty()) {
            return Optional.empty();
        }

        var entity = ReservationConverter.toEntity(dto.get());
        return Optional.of(entity);
    }

    @Override
    public Reservation findRequired(ReservationNumber reservationNumber) {
        var optionalBankReservation = find(reservationNumber);

        if (optionalBankReservation.isEmpty()) {
            throw new ValidationException(ValidationMessages.RESERVATION_NUMBER_NOT_EXIST);
        }

        return optionalBankReservation.get();
    }

    @Override
    public void add(Reservation reservation) {
        var dto = ReservationConverter.toDto(reservation);
        reservationStorage.add(dto);
    }

    @Override
    public void update(Reservation reservation) {
        var dto = ReservationConverter.toDto(reservation);
        reservationStorage.update(dto);
    }

    @Override
    public ReservationId nextReservationId() {
        var reservationId = reservationIdGenerator.next();
        return ReservationId.of(reservationId);
    }

    @Override
    public ReservationNumber nextReservationNumber() {
        var reservationNumber = reservationNumberGenerator.next();
        return ReservationNumber.of(reservationNumber);
    }
}
