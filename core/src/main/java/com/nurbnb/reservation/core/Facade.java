package com.nurbnb.reservation.core;

import com.nurbnb.reservation.core.internal.cleanarch.acl.ReservationRepositoryImpl;
import com.nurbnb.reservation.core.internal.cleanarch.acl.EventPublisherImpl;
import com.nurbnb.reservation.core.internal.cleanarch.usecases.ViewReservationUseCase;
import com.nurbnb.reservation.core.ports.driven.*;
import com.nurbnb.reservation.core.ports.driver.reservations.viewreservation.ViewReservationRequest;
import com.nurbnb.reservation.core.ports.driver.reservations.viewreservation.ViewReservationResponse;

public class Facade {

    private final ViewReservationUseCase viewReservationUseCase;

    public Facade(NationalIdentityGateway nationalIdentityGateway, CustomerGateway customerGateway, ReservationIdGenerator reservationIdGenerator, ReservationNumberGenerator reservationNumberGenerator, DateTimeService dateTimeService, ReservationStorage reservationStorage, EventBus eventBus) {
        var reservationRepository = new ReservationRepositoryImpl(reservationStorage, reservationIdGenerator, reservationNumberGenerator);
        var eventPublisher = new EventPublisherImpl(eventBus);

        this.viewReservationUseCase = new ViewReservationUseCase(reservationRepository);
    }

    public ViewReservationResponse execute(ViewReservationRequest request) {
        return viewReservationUseCase.handle(request);
    }


}
