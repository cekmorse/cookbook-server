package com.github.cekmorse.api.exception;

import lombok.NoArgsConstructor;

/**
 * Created by keith on 6/22/17.
 */
@NoArgsConstructor
public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(Throwable cause)
    {
        super(cause);
    }

    public ResourceNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
