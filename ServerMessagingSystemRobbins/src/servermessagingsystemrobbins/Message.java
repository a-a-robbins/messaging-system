package servermessagingsystemrobbins;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 *
 * @author a-a-robbins
 */

//creates Message objects to store public message information
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
    
    //put all criteria together to make a message
    public String buildString() {
        String m = "date: " + timestamp + ",    sender: " + sender + ",     hashtag: " + hashtag + ",   message: " + message; 
        return m; 
    }
    
}
