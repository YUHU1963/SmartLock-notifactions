package com.example.smartlock;
public class CustomNotification {
    private String content;
    private boolean isError;

    public CustomNotification(String content, boolean isError) {
        this.content = content;
        this.isError = isError;
    }

    public String getContent() { return content; }
    public boolean isError() { return isError; }
}
