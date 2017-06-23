package com.github.cekmorse.api.exception;

import lombok.NoArgsConstructor;

/**
 * Created by keith on 6/22/17.
 */
@NoArgsConstructor
public class BadRequestException extends Exception {
    public BadRequestException(Throwable cause)
    {
        super(cause);
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
