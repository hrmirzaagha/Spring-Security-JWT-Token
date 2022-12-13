package com.software.tokens.exception;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ErrorDetails {

    private Calendar timestamp;
    private String name;
    private List<String> messages;
    private String details;

    public ErrorDetails() {
    }

    public ErrorDetails(Calendar timestamp, String name, List<String> messages, String details) {
        this.timestamp = timestamp;
        this.name = name;
        this.messages = messages;
        this.details = details;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Calendar timestamp) {
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMessages() {

        if (messages == null) {
            messages = new ArrayList<>();
        }
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
