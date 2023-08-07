package com.nurbnb.reservation.adapter.driven.persistence.jpa.internal;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

import org.hibernate.type.EnumType;


@Data
@Entity
@Table(name = "reservation")
public class ReservationRecord {

	public enum Status {PENDING, CONFIRMED, TERMINATED, CANCELLED}

	public enum PaymentType {CASH, CREDIT, UNDEFINED}

	@Id
    @Column(name = "reservation_id")
    private long id;

    @Column(name = "reservation_number", unique = true, nullable = false)
    private String reservationNumber;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

	@Enumerated(EnumType.STRING)
    @Column(name = "status", defaultValue = Enum.valueOf(Status.PENDING), nullable = false)
	private Status status;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "payment_type", defaultValue = Enum.valueOf(PaymentType.UNDEFINED), nullable = false)
	private PaymentType paymentType;

}
