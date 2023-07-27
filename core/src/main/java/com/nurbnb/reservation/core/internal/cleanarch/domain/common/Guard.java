package com.nurbnb.reservation.core.internal.cleanarch.domain.common;

import com.nurbnb.reservation.core.internal.cleanarch.domain.reservations.Money;
import com.nurbnb.reservation.core.internal.cleanarch.domain.reservations.Text;
import com.nurbnb.reservation.core.internal.cleanarch.domain.common.guards.LongGuard;
import com.nurbnb.reservation.core.internal.cleanarch.domain.common.guards.MoneyGuard;
import com.nurbnb.reservation.core.internal.cleanarch.domain.common.guards.ObjectGuard;
import com.nurbnb.reservation.core.internal.cleanarch.domain.common.guards.TextGuard;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Guard {
    public static LongGuard guard(long value) {
        return new LongGuard(value);
    }

    public static MoneyGuard guard(Money value) {
        return new MoneyGuard(value);
    }

    public static ObjectGuard guard(Object value) { return new ObjectGuard(value); }

    public static TextGuard guard(Text value) {
        return new TextGuard(value);
    }
    public static TextGuard guard(String value) {
        return new TextGuard(new Text(value));
    }
}
