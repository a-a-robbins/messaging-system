/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermessagingsystemrobbins;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author a-a-robbins
 */
public class MessageList2 {
    private ArrayList <Message> list;
    
    MessageList2(){
        list = new ArrayList();
    }
    
    
public String send(String sender, String hashtag, String message, LocalDate timestamp) {
   // String name = sender.getName(); 
    Message m = new Message(sender, hashtag, message, timestamp); 
    list.add(m); 

    return "Message sent successfully"; 
}

public MessageList2 retrieve(String keyword, FollowList sender, LocalDate timestamp) {
    MessageList2 mList = new MessageList2();
    
    //FIXME: Unread and Refresh should only be retrieving messages of who the user follows
    
    switch(keyword){
        case "Unread" :
            String[] followList = new String[sender.size()]; 
            for(int i = 0; i < sender.size(); i++) {
                followList[i] = sender.get(i); 
            }
            for(int i = 0; i < list.size(); i++) {
               Message m = list.get(i);
               for(int j = 0; j < followList.length; j++) {
                   if(followList[j].equals(m.getSender())) {
                       if(m.getTimestamp().isBefore(LocalDate.now()) || (m.getTimestamp().isEqual(LocalDate.now()))) {
                           mList.add(m); 
                       }
                   }
               }
            }
   
            return mList; 
            
        case "Refresh" :
            followList = new String[sender.size()]; 
            for(int i = 0; i < sender.size(); i++) {
                followList[i] = sender.get(i); 
            }
            for(int i = 0; i < list.size(); i++) {
               Message m = list.get(i);
               for(int j = 0; j < followList.length; j++) {
                   if(followList[j].equals(m.getSender())) {
                       if(m.getTimestamp().isBefore(LocalDate.now()) || (m.getTimestamp().isEqual(LocalDate.now()))) {
                           mList.add(m); 
                       }
                   }
               }
            }
   
            return mList;
            
    }
    return mList; 
}

    public MessageList2 search(String keyword, LocalDate timestamp) {
        MessageList2 searchList = new MessageList2(); 
        for(int i = 0; i < list.size(); i++) {
                Message m = list.get(i); 
                if((m.getHashtag().equals(keyword)) || ((m.getSender().equals(keyword)))) {
                    searchList.add(m); 
                }
            }
        return searchList; 
    }

    public void add(Message m) {
        list.add(m); 
    }

    public int size() {
        return list.size(); 
    }
    
    public String get(int index ) {
        Message m = list.get(index); 
        String message = m.buildString(); 
        return message; 
    }

}
