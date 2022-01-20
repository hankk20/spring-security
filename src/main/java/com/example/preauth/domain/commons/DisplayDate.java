package com.example.preauth.domain.commons;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DisplayDate {

    private DateTimeFormatter dateTimeFormatter;
    private TemporalAccessor temporalAccessor;

    public DisplayDate(String dateFormat, TemporalAccessor temporalAccessor) {
        this.dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
        this.temporalAccessor = temporalAccessor;
    }

    public String toString(){
        return dateTimeFormatter.format(this.temporalAccessor);
    }
}
