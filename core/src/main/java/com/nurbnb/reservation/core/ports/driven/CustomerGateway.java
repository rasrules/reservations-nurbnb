package com.nurbnb.reservation.core.ports.driven;

public interface CustomerGateway {
    boolean isBlacklisted(String nationalIdentityNumber);
}
