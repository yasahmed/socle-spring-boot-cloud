package com.socle.commons.exceptions;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
    private String code;

    public ErrorDetails(Date timestamp, String message, String details,String code) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.code = code;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public String getCode() {
        return code;
    }
}