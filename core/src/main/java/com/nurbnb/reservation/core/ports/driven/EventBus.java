package com.nurbnb.reservation.core.ports.driven;

import com.nurbnb.reservation.core.ports.driven.events.EventDto;

public interface EventBus {
    void publish(EventDto event);
}
