package com.nurbnb.reservation.core.internal.cleanarch.domain.common.guards;

import com.nurbnb.reservation.core.internal.cleanarch.domain.reservations.Money;

public class MoneyGuard extends BaseGuard<Money> {
    public MoneyGuard(Money value) {
        super(value);
    }

    public void againstNegative(String message) {
        against(value::isNegative, message);
    }

    public void againstNonPositive(String message) {
        against(value::isNonPositive, message);
    }
}
