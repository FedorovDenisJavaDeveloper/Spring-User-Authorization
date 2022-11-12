package ru.netology.exception.exceptions;

public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String message) {
        super(message);
    }
}
