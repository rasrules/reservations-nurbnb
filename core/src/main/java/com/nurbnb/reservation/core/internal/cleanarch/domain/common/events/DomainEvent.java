package com.nurbnb.reservation.core.internal.cleanarch.domain.common.events;

import java.time.LocalDateTime;

public interface DomainEvent {
    LocalDateTime getTimestamp();
}
