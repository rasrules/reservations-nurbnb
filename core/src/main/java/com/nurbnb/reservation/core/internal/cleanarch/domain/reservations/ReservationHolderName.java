package com.nurbnb.reservation.core.internal.cleanarch.domain.reservations;

import com.nurbnb.reservation.core.ports.driver.exceptions.ValidationMessages;

import static com.nurbnb.reservation.core.internal.cleanarch.domain.common.Guard.guard;

public record ReservationHolderName(Text firstName, Text lastName) {

    public ReservationHolderName {
        guard(firstName).againstNullOrWhitespace(ValidationMessages.FIRST_NAME_EMPTY);
        guard(lastName).againstNullOrWhitespace(ValidationMessages.LAST_NAME_EMPTY);
    }

    public static ReservationHolderName of(String firstName, String lastName) {
        return new ReservationHolderName(Text.of(firstName), Text.of(lastName));
    }

    public Text getFullName() {
        return firstName().addSpace().add(lastName());
    }

    @Override
    public String toString() {
        return getFullName().value();
    }
}
