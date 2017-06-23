package com.github.cekmorse.api.converter;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.Date;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

/**
 * Created by keith on 6/22/17.
 */
public class DateDateTimeBidirectionalConverter extends BidirectionalConverter<Date, DateTime> {
    @Override
    public DateTime convertTo(Date aDate, Type<DateTime> aType) {
        if (aDate == null)
        {
            return null;
        }
        return new DateTime(aDate.getTime()).toDateTime(DateTimeZone.UTC);
    }

    @Override
    public Date convertFrom(DateTime aDateTime, Type<Date> aType) {
        if (aDateTime == null)
        {
            return null;
        }
        return aDateTime.toDate();
    }
}
