package com.stac.history_service.errors.exceptions;

public class HistoryNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public HistoryNotFoundException(String message) {super(message);}
}
