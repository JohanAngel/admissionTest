package com.sprint3.admission_test.domain.exceptions;

import java.time.LocalDate;

public class ExpirationDateIsBeforeToday extends RuntimeException {
    public ExpirationDateIsBeforeToday(LocalDate date, LocalDate dateToday) {
        super("The expiration date: " + date.toString() + " is smaller than " + dateToday.toString());
    }
}
