package com.nurbnb.reservation.core.internal.cleanarch.acl;

import com.nurbnb.reservation.core.internal.cleanarch.domain.reservations.ReservationOpened;
import com.nurbnb.reservation.core.internal.cleanarch.domain.reservations.FundsDeposited;
import com.nurbnb.reservation.core.internal.cleanarch.domain.reservations.FundsWithdrawn;
import com.nurbnb.reservation.core.internal.cleanarch.domain.common.events.DomainEvent;
import com.nurbnb.reservation.core.internal.cleanarch.domain.common.events.EventPublisher;
import com.nurbnb.reservation.core.ports.driven.EventBus;
import com.nurbnb.reservation.core.ports.driven.events.EventDto;
import org.springframework.stereotype.Component;

@Component
public class EventPublisherImpl implements EventPublisher {

    private final EventBus eventBus;

    public EventPublisherImpl(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void publishEvent(DomainEvent event) {
        var eventDto = getEventDto(event);
        eventBus.publish(eventDto);
    }

    private EventDto getEventDto(DomainEvent event) {
        if(event instanceof ReservationOpened)
        {
            return ReservationOpenedConverter.fromEvent((ReservationOpened) event);
        }
        else if(event instanceof FundsDeposited) {
            return FundsDepositedConverter.fromEvent((FundsDeposited) event);
        }
        else if(event instanceof FundsWithdrawn) {
            return FundsWithdrawnConverter.fromEvent((FundsWithdrawn) event);
        }

        throw new IllegalArgumentException("Unrecognized event type");
    }
}
