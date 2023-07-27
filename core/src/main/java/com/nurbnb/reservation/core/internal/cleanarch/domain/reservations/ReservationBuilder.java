package com.nurbnb.reservation.core.internal.cleanarch.domain.reservations;

import java.time.LocalDate;

public class ReservationBuilder {
    public static ReservationBuilder bankReservation() {
        return new ReservationBuilder();
    }
    private ReservationId reservationId;
    private ReservationNumber reservationNumber;
    private String nationalIdentityNumber;
    private ReservationHolderName reservationHolderName;
    private LocalDate openingDate;

    public ReservationBuilder withReservationId(ReservationId reservationId) {
        this.reservationId = reservationId;
        return this;
    }

    public ReservationBuilder withReservationNumber(ReservationNumber reservationNumber) {
        this.reservationNumber = reservationNumber;
        return this;
    }

    public ReservationBuilder withNationalIdentityNumber(String nationalIdentityNumber) {
        this.nationalIdentityNumber = nationalIdentityNumber;
        return this;
    }

    public ReservationBuilder withReservationHolderName(ReservationHolderName reservationHolderName) {
        this.reservationHolderName = reservationHolderName;
        return this;
    }

    public ReservationBuilder withOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
        return this;
    }

    public Reservation build() {
        return new Reservation(reservationId, reservationNumber, nationalIdentityNumber, reservationHolderName, openingDate);
    }


}
