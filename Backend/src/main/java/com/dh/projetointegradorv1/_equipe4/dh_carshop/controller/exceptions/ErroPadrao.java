package com.dh.projetointegradorv1._equipe4.dh_carshop.controller.exceptions;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class ErroPadrao implements Serializable {

    private OffsetDateTime timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public ErroPadrao() {
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
