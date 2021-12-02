/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermessagingsystemrobbins;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 *
 * @author a-a-robbins
 */
public class Message {
    private String sender; 
    private String hashtag; 
    private String message; 
    private LocalDate timestamp; 
    
    public Message(String sender, String hashtag, String message, LocalDate timestamp) {
        this.sender = sender; 
        this.hashtag = hashtag; 
        this.message = message; 
        this.timestamp = timestamp; 
    }
    
    
    public String getSender() {
        return sender; 
    }
    
    public String getHashtag() {
        return hashtag; 
    }
    
    public String getMessage() {
        return message; 
    }
    
    public LocalDate getTimestamp() {
        return timestamp; 
    }
    
    public String buildString() {
        String m = "date: " + timestamp + ",    sender: " + sender + ",     hashtag: " + hashtag + ",   message: " + message; 
        return m; 
    }
    
}
