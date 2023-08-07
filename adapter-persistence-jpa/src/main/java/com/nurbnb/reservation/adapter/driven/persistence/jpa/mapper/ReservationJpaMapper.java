package com.nurbnb.reservation.adapter.driven.persistence.jpa.mapper;


import com.nurbnb.reservation.adapter.driven.persistence.jpa.internal.ReservationRecord;
import com.nurbnb.reservation.core.ports.driven.ReservationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ReservationJpaMapper {

    @Mapping(target = "id", source = "reservationRecord.id")
    @Mapping(target = "reservationNumber", source = "reservationRecord.reservationNumber")
    @Mapping(target = "createdAt", source = "reservationRecord.createdAt")
	@Mapping(target = "startDate", source = "reservationRecord.startDate")
	@Mapping(target = "endDate", source = "reservationRecord.endDate")
    @Mapping(target = "status", source = "dto.status", defaultExpression = "java(reservationRecord.getStatus())")
    @Mapping(target = "paymentType", source = "dto.paymentType", defaultExpression = "java(reservationRecord.getPaymentType())")	
    ReservationRecord toRecord(ReservationDto dto, ReservationRecord reservationRecord);
}
