package com.nurbnb.reservation.adapter.driver.restapi.spring.controllers;

import com.nurbnb.reservation.adapter.driver.restapi.spring.controllers.base.BaseController;
import com.nurbnb.reservation.core.ports.driver.reservations.viewreservation.ViewReservationRequest;
import com.nurbnb.reservation.core.ports.driver.reservations.viewreservation.ViewReservationResponse;
import com.nurbnb.reservation.core.ports.driver.exceptions.ValidationException;
import com.nurbnb.reservation.core.ports.driver.exceptions.ValidationMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController extends BaseController {

    @GetMapping("/reservations/{reservationNumber}")
    public ResponseEntity<ViewReservationResponse> viewReservation(@PathVariable String reservationNumber) {
        var request = ViewReservationRequest.builder()
                .reservationNumber(reservationNumber)
                .build();

        try {
            var response = pipeline.send(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ValidationException ex) {
            // TODO: Refactor to centralized error handling
            if(ex.getMessage().equals(ValidationMessages.RESERVATION_NUMBER_NOT_EXIST)) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                throw ex;
            }
        }
    }
}
