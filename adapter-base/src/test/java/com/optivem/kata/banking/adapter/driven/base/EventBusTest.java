package com.nurbnb.reservation.adapter.driven.base;

import com.nurbnb.reservation.core.ports.driven.EventBus;
import com.nurbnb.reservation.core.ports.driven.events.AccountOpenedDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class EventBusTest<T extends EventBus> {

    protected T eventBus;

    @BeforeEach
    public void init() {
        this.eventBus = create();
    }

    protected abstract T create();

    @Test
    void should_execute_without_error() {
        var eventDto = new AccountOpenedDto();
        eventBus.publish(eventDto);
    }
}
