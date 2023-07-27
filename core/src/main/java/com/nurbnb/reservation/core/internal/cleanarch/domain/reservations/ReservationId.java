package com.nurbnb.reservation.core.internal.cleanarch.domain.reservations;

import com.nurbnb.reservation.core.ports.driver.exceptions.ValidationMessages;

import static com.nurbnb.reservation.core.internal.cleanarch.domain.common.Guard.guard;

public record ReservationId(long value) {
    public static ReservationId of(long value) {
        guard(value).againstNonPositive(ValidationMessages.RESERVATION_ID_NON_POSITIVE);
        return new ReservationId(value);
    }

    public long toLong() {
        return value;
    }
}
