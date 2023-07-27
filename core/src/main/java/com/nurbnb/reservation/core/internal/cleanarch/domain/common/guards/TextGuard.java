package com.nurbnb.reservation.core.internal.cleanarch.domain.common.guards;

import com.nurbnb.reservation.core.internal.cleanarch.domain.reservations.Text;

public class TextGuard extends BaseGuard<Text> {

    public TextGuard(Text value) {
        super(value);
    }

    public void againstNullOrWhitespace(String message) {
        against(value::isNullOrWhitespace, message);
    }
}
