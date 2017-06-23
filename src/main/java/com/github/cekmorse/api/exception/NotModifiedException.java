package com.github.cekmorse.api.exception;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import lombok.NoArgsConstructor;

import static com.github.cekmorse.api.util.HttpConstants.HEADER_DATE_FORMAT;
import static com.github.cekmorse.api.util.HttpConstants.HEADER_DATE_FORMAT_TIMEZONE;

/**
 * Created by keith on 6/22/17.
 */
@NoArgsConstructor
public class NotModifiedException extends Exception {
    private static SimpleDateFormat format = getHeaderDateFormatter();

    public NotModifiedException(Date aLastModifiedAtDate)
    {
        this("Last Modified at " + format.format(aLastModifiedAtDate));
    }

    public NotModifiedException(Throwable cause)
    {
        super(cause);
    }

    public NotModifiedException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public NotModifiedException(String message)
    {
        super(message);
    }

    protected static SimpleDateFormat getHeaderDateFormatter() {
        if (format == null)
        {
            format = new SimpleDateFormat(HEADER_DATE_FORMAT);
            format.setTimeZone(TimeZone.getTimeZone(HEADER_DATE_FORMAT_TIMEZONE));
        }
        return format;
    }
}

