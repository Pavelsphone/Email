package com.example.myapplication;

public class Email {
    private String sender;
    private String subject;
    private String content;
    private String date;

    public Email(String sender, String subject, String content, String date) {
        this.sender = sender;
        this.subject = subject;
        this.content = content;
        this.date = date;
    }

    // Геттеры
    public String getSender() { return sender; }
    public String getSubject() { return subject; }
    public String getContent() { return content; }
    public String getDate() { return date; }
}

