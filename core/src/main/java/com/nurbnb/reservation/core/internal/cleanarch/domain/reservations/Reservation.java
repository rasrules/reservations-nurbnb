package com.nurbnb.reservation.core.internal.cleanarch.domain.reservations;

import com.nurbnb.reservation.core.internal.cleanarch.domain.common.Guard;
import com.nurbnb.reservation.core.ports.driver.exceptions.ValidationException;
import com.nurbnb.reservation.core.ports.driver.exceptions.ValidationMessages;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

import static com.nurbnb.reservation.core.internal.cleanarch.domain.common.Guard.guard;

@EqualsAndHashCode
public class Reservation {
    private final ReservationId reservationId;
    private final ReservationNumber reservationNumber;
    private final String nationalIdentityNumber;
    private final ReservationHolderName reservationHolderName;
    private final LocalDate openingDate;


    public Reservation(ReservationId reservationId, ReservationNumber reservationNumber, String nationalIdentityNumber, ReservationHolderName reservationHolderName, LocalDate openingDate) {
        Guard.guard(nationalIdentityNumber).againstNullOrWhitespace(ValidationMessages.NATIONAL_IDENTITY_NUMBER_EMPTY);
        Guard.guard(reservationId).againstNull(ValidationMessages.RESERVATION_ID_EMPTY);
        Guard.guard(reservationNumber).againstNull(ValidationMessages.RESERVATION_NUMBER_EMPTY);
        Guard.guard(reservationHolderName).againstNull(ValidationMessages.RESERVATION_HOLDER_NAME_EMPTY);
        Guard.guard(openingDate).againstNull(ValidationMessages.OPENING_DATE_EMPTY);

        this.reservationId = reservationId;
        this.reservationNumber = reservationNumber;
        this.nationalIdentityNumber = nationalIdentityNumber;
        this.reservationHolderName = reservationHolderName;
        this.openingDate = openingDate;
    }

    public Reservation(Reservation other) {
        this(other.getReservationId(), other.getReservationNumber(), other.getNationalIdentityNumber(), other.getReservationHolderName(), other.getOpeningDate());
    }

    public ReservationId getReservationId() { return reservationId; }

    public ReservationNumber getReservationNumber() {
        return reservationNumber;
    }

    public String getNationalIdentityNumber() {
        return nationalIdentityNumber;
    }

    public ReservationHolderName getReservationHolderName() {
        return reservationHolderName;
    }

    public LocalDate getOpeningDate() { return openingDate; }


}
