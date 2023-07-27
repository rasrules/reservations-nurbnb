package com.nurbnb.reservation.core.internal.cleanarch.usecases;

import an.awesome.pipelinr.Command;
import com.nurbnb.reservation.core.internal.cleanarch.domain.reservations.ReservationNumber;
import com.nurbnb.reservation.core.internal.cleanarch.domain.reservations.Reservation;
import com.nurbnb.reservation.core.internal.cleanarch.domain.reservations.ReservationRepository;
import com.nurbnb.reservation.core.ports.driver.reservations.viewreservation.ViewReservationRequest;
import com.nurbnb.reservation.core.ports.driver.reservations.viewreservation.ViewReservationResponse;

import org.springframework.stereotype.Component;

@Component
public class ViewReservationUseCase implements Command.Handler<ViewReservationRequest, ViewReservationResponse> {

    private final ReservationRepository repository;

    public ViewReservationUseCase(ReservationRepository repository) {
        this.repository = repository;
    }

    @Override
    public ViewReservationResponse handle(ViewReservationRequest request) {
        var reservationNumber = getReservationNumber(request);
        var reservation = repository.findRequired(reservationNumber);
        return getResponse(reservation);
    }

    private ReservationNumber getReservationNumber(ViewReservationRequest request) {
        return ReservationNumber.of(request.getReservationNumber());
    }

    private ViewReservationResponse getResponse(Reservation reservation) {
        var reservationNumber = reservation.getReservationNumber().toString();
        var fullName = reservation.getReservationHolderName().toString();

        return ViewReservationResponse.builder()
                .reservationNumber(reservationNumber)
                .fullName(fullName)
                .build();
    }
}
