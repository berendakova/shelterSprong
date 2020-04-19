package ru.itis.springbootdemo.exceptions;

public class NotCorrectSamePassword extends Exception {
    public NotCorrectSamePassword(String message) {
        super(message);
    }
}