package com.test.model;

import java.io.Serializable;

public class BasicResponse implements Serializable {
    private boolean status;
    private String message;

    public BasicResponse(boolean status, String message) {
        this.status = status;
        this.message = message;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
