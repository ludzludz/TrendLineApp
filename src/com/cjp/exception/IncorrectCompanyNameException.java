package com.cjp.exception;

/**
 * Created by Luxoft on 2015-07-23.
 */
public class IncorrectCompanyNameException extends Exception {

    public IncorrectCompanyNameException() {
    }


    public IncorrectCompanyNameException(String message) {
        super(message);
    }
}
