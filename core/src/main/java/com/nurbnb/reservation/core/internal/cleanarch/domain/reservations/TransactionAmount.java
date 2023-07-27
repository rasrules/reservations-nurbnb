package com.nurbnb.reservation.core.internal.cleanarch.domain.reservations;

import com.nurbnb.reservation.core.ports.driver.exceptions.ValidationMessages;

import static com.nurbnb.reservation.core.internal.cleanarch.domain.common.Guard.guard;

public record TransactionAmount(Money value) {

    public TransactionAmount {
        guard(value).againstNonPositive(ValidationMessages.AMOUNT_NOT_POSITIVE);
    }

    public static TransactionAmount of(Money value) {
        return new TransactionAmount(value);
    }

    public static TransactionAmount of(int value) {
        return of(Money.of(value));
    }
}
