package com.nurbnb.reservation.core.ports.driven;

public interface NationalIdentityGateway {
    boolean exists(String nationalIdentityNumber);
}
