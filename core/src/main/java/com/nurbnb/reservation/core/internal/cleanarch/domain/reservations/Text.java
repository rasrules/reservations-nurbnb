package com.nurbnb.reservation.core.internal.cleanarch.domain.reservations;

public record Text(String value) {
    private static final Text SPACE = Text.of(" ");

    public boolean isNullOrWhitespace() {
        return value == null || value.trim().equals("");
    }

    public static Text of(String value) {
        return new Text(value);
    }

    public Text add(Text other) {
        return Text.of(value.concat(other.value));
    }

    public Text addSpace() {
        return add(SPACE);
    }

    public int getLength() {
        return value.length();
    }

    @Override
    public String toString() {
        return value();
    }
}
