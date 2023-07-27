package com.nurbnb.reservation.core.internal.cleanarch.domain.common.events;

import com.nurbnb.reservation.core.internal.cleanarch.domain.common.events.DomainEvent;

public interface EventPublisher {
    void publishEvent(DomainEvent event);
}
