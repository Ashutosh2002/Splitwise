package dev.Ashutosh.Splitwise.exceptions;

public class GroupNotFoundException extends RuntimeException{

    public GroupNotFoundException() {
    }

    public GroupNotFoundException(String message) {
        super(message);
    }
}
