package com.gl.blogApp.payload;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;



    public ErrorDetails( Date timestamp, String message,String details) {
        this.message = message;
        this.timestamp = timestamp;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getDetails() {
        return details;
    }

    public String getMessage() {
        return message;
    }
}
