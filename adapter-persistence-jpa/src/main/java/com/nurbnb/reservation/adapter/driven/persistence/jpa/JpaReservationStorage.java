package com.nurbnb.reservation.adapter.driven.persistence.jpa;

import com.nurbnb.reservation.adapter.driven.base.ProfileNames;
import com.nurbnb.reservation.adapter.driven.persistence.jpa.internal.ReservationRecord;
import com.nurbnb.reservation.adapter.driven.persistence.jpa.internal.JpaReservationDataAccessor;
import com.nurbnb.reservation.adapter.driven.persistence.jpa.mapper.ReservationJpaMapper;
import com.nurbnb.reservation.core.ports.driven.ReservationDto;
import com.nurbnb.reservation.core.ports.driven.ReservationStorage;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Consumer;

@Primary
@Component
@Profile(ProfileNames.ADAPTER_PERSISTENCE_JPA)
public class JpaReservationStorage implements ReservationStorage {

    private final JpaReservationDataAccessor dataAccessor;
    private final ReservationJpaMapper reservationJpaMapper;

    public JpaReservationStorage(JpaReservationDataAccessor dataAccessor, ReservationJpaMapper reservationJpaMapper) {
        this.dataAccessor = dataAccessor;
        this.reservationJpaMapper = reservationJpaMapper;
    }

    @Override
    public Optional<ReservationDto> find(String reservationNumber) {
        var reservationRecord = dataAccessor.findByReservationNumber(reservationNumber);

        if(reservationRecord.isEmpty()) {
            return Optional.empty();
        }

        var reservation = toDto(reservationRecord.get());
        return Optional.of(reservation);
    }

    @Override
    public void add(ReservationDto reservation) {
        var reservationRecord = create(reservation);
        dataAccessor.save(reservationRecord);
    }

    @Override
    public void update(ReservationDto reservationDto) {
        var reservationModelOptional = findByReservationNumber(reservationDto.getReservationNumber());
        reservationModelOptional.ifPresent(updateTheModelWithInformationFrom(reservationDto));
    }

    private ReservationRecord create(ReservationDto reservation) {
        var reservationRecord = new ReservationRecord();
        reservationRecord.setId(reservation.getReservationId());
        reservationRecord.setReservationNumber(reservation.getReservationNumber());
        reservationRecord.setCreatedAt(reservation.getCreatedAt());
		reservationRecord.setStartDate(reservation.getStartDate());
		reservationRecord.setEndDate(reservation.getEndDate());
        reservationRecord.setStatus(reservation.getStatus());
        reservationRecord.setPaymentType(reservation.getPaymentType());
        return reservationRecord;
    }

    private ReservationDto toDto(ReservationRecord reservationRecord) {
        var dto = new ReservationDto();
        dto.setReservationId(reservationRecord.getId());
        dto.setReservationNumber(reservationRecord.getReservationNumber());
        dto.setFirstName(reservationRecord.getFirstName());
        dto.setLastName(reservationRecord.getLastName());
        dto.setOpeningDate(reservationRecord.getOpeningDate());
        dto.setBalance(reservationRecord.getBalance());
        return dto;
    }

    private Optional<ReservationRecord> findByReservationNumber(String reservationNumber) {
        return dataAccessor.findByResevationNumber(reservationNumber);
    }

    private Consumer<ReservationRecord> updateTheModelWithInformationFrom(ReservationDto reservationDto) {
        return reservationRecord -> {
            var updatedReservationModel = reservationJpaMapper.toRecord(reservationDto, reservationRecord);
            dataAccessor.save(updatedReservationModel);
        };
    }
}
