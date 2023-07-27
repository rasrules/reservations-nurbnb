package com.nurbnb.reservation.core.internal.cleanarch.acl;

import com.nurbnb.reservation.core.internal.cleanarch.domain.reservations.*;
import com.nurbnb.reservation.core.ports.driven.ReservationDto;

public class ReservationConverter {
    public static Reservation toEntity(ReservationDto dto) {
        var reservationId = ReservationId.of(dto.getReservationId());
        var reservationNumber = ReservationNumber.of(dto.getReservationNumber());
        var nationalIdentityNumber = dto.getNationalIdentityNumber();
        var reservationHolderName = ReservationHolderName.of(dto.getFirstName(), dto.getLastName());
        var openingDate = dto.getOpeningDate();

        return new Reservation(reservationId, reservationNumber, nationalIdentityNumber, reservationHolderName, openingDate);
    }

    public static ReservationDto toDto(Reservation bankReservation) {
        var reservationId = bankReservation.getReservationId().toLong();
        var reservationNumber = bankReservation.getReservationNumber().toString();
        var nationalIdentityNumber = bankReservation.getNationalIdentityNumber();
        var firstName = bankReservation.getReservationHolderName().firstName().toString();
        var lastName = bankReservation.getReservationHolderName().lastName().toString();
        var openingDate = bankReservation.getOpeningDate();

        var dto = new ReservationDto();
        dto.setReservationId(reservationId);
        dto.setReservationNumber(reservationNumber);
        dto.setNationalIdentityNumber(nationalIdentityNumber);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setOpeningDate(openingDate);

        return dto;
    }
}
