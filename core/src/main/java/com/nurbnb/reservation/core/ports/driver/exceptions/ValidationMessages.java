package com.nurbnb.reservation.core.ports.driver.exceptions;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidationMessages {
    public static final String NATIONAL_IDENTITY_NUMBER_EMPTY = "National identity number is empty";
    public static final String NATIONAL_IDENTITY_NUMBER_NONEXISTENT = "National identity number does not exist";

    public static final String NATIONAL_IDENTITY_NUMBER_BLACKLISTED = "National identity number is a blacklisted customer";
    public static final String FIRST_NAME_EMPTY = "First name is empty";
    public static final String LAST_NAME_EMPTY = "Last name is empty";
    public static final String BALANCE_NEGATIVE = "Balance is negative";
    public static final String RESERVATION_NUMBER_EMPTY = "Reservation number is empty";
    public static final String RESERVATION_NUMBER_NOT_EXIST = "Reservation number does not exist";
    public static final String AMOUNT_NOT_POSITIVE = "Amount is not positive";
    public static final String INSUFFICIENT_FUNDS = "Insufficient funds";
    public static final String RESERVATION_HOLDER_NAME_EMPTY = "Reservation holder name is empty";
    public static final String OPENING_DATE_EMPTY = "Opening date is empty";
    public static final String BALANCE_EMPTY = "Balance is empty";
    public static final String RESERVATION_ID_EMPTY = "Reservation ID is empty";
    public static final String RESERVATION_ID_NON_POSITIVE = "Reservation ID is not positive";



}
