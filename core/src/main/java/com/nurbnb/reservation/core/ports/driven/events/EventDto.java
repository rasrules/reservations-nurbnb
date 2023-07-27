package com.nurbnb.reservation.core.ports.driven.events;

import java.time.LocalDateTime;

public interface EventDto {
    LocalDateTime getTimestamp();
}
