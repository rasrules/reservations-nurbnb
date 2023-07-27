package com.nurbnb.reservation.adapter.time.system;

import com.nurbnb.reservation.adapter.driven.base.ProfileNames;
import com.nurbnb.reservation.core.ports.driven.DateTimeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Profile(ProfileNames.ADAPTER_TIME_SYSTEM)
public class SysDateTimeService implements DateTimeService {
    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
