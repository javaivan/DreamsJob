package com.ivanmix.exception;

/**
 * Created by ivan on 28.05.2016.
 */
public class UserIsNotFound extends Exception {
    public UserIsNotFound() { super(); }
    public UserIsNotFound(String message) { super(message); }
    public UserIsNotFound(String message, Throwable cause) { super(message, cause); }
    public UserIsNotFound(Throwable cause) { super(cause); }
}
