package com.nurbnb.reservation.core.internal.cleanarch.domain.reservations;

import com.nurbnb.reservation.core.internal.cleanarch.domain.common.Guard;
import com.nurbnb.reservation.core.ports.driver.exceptions.ValidationMessages;

public record ReservationNumber(Text value) {

    public ReservationNumber {
        Guard.guard(value).againstNullOrWhitespace(ValidationMessages.RESERVATION_NUMBER_EMPTY);
    }

    public static ReservationNumber of(String value) {
        return new ReservationNumber(Text.of(value));
    }

    @Override
    public String toString() {
        return value.value();
    }
}
