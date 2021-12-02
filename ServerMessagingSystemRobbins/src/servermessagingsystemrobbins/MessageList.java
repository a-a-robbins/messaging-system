package servermessagingsystemrobbins;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author a-a-robbins
 */
public class MessageList {
    
    //instance variables
    private ArrayList <Message> list;
    private HashMap<LocalDate, ArrayList<Message>> map; 

    
    
    //constructor
    MessageList() {
         //initializing new arraylist to keep message objects
        list = new ArrayList();
        
        //initializing new hashmap to store dates and arraylist
        map = new HashMap<>(); 
    }
    
    //create new message in array list, convert timestamp to yyyy-mm-dd string and save in hashmap
    public String send(String sender, String hashtag, String message, LocalDate timestamp) {
       Message m = new Message(sender, hashtag, message, timestamp); 
 
        
        //we need to use a date or some other date like object
        //SimpleDateFormat time = timestamp.SimpleDateFormat("yyyy-MM-dd"); 

        
        //if this thing is first message on a new day
        if(!map.containsKey(timestamp)) {
            //create an empty list and put this message in an empty list
            list.add(m); 
            map.put(timestamp, list);
            
            //testing
            System.out.println("array list: " + list);
            System.out.println("hash map: " + map);
        }
        //if there is already something there then
        else {
            //get that list that is associated that day
            map.get(timestamp); 
            list.add(m); //NOTE: might need to add map.put...
            
            //testing
            System.out.println("array list: " + list);
            System.out.println("hash map: " + map);
        }

        return "Message sent successfully"; 
    }
    
    //retrieve message by either hashmap key OR keyword in arraylist
    public ArrayList retrieve(String keyword, String name, LocalDate timestamp) {
       //return an array list of messages
       ArrayList<Message> mList = new ArrayList(); 
        switch(keyword) {
            case "Unread" :
                //get key set
                Collection<LocalDate> keys = map.keySet(); 
                Object[] dates = keys.toArray(); 

                //get messages sent before current date
                for(int i = 0; i < dates.length; i++) {
                    if(timestamp.isBefore((LocalDate)dates[i])) {
                       LocalDate key = (LocalDate)dates[i]; 
                       mList.addAll(map.get(key)); 
                    }
                }
               return mList; 
               
            case "All" :             
                //get key set
                keys = map.keySet(); 
                dates = keys.toArray(); 
                             
                //get messages all messages sent ever
                for(int i = 0; i < dates.length; i++) {
                       LocalDate key = (LocalDate)dates[i]; 
                       mList.addAll(map.get(key)); 
                }
                
               return mList; 
                
            case "Refresh" : 
                timestamp = LocalDate.now(); 
                  //get key set
                keys = map.keySet(); 
                dates = keys.toArray(); 
                             
                //get messages sent before current date
                for(int i = 0; i < dates.length; i++) {
                    if(timestamp.isBefore((LocalDate)dates[i])) {
                       LocalDate key = (LocalDate)dates[i]; 
                       mList.addAll(map.get(key)); 
                    }
                }
                
               return mList;
                            
            case "Search" :
                //get key set
                keys = map.keySet(); 
                dates = keys.toArray(); 
                
                Collection<ArrayList<Message>> messages = map.values();
                System.out.println("Test of the Collection, ArrayList<Message>: " + messages); 
                //Object[] searchArray = messages.toArray(); 
                       
                //get all messages and check for keyword
                /*for(int i = 0; i < dates.length; i++) {
                       LocalDate key = (LocalDate)dates[i]; 
                       if((Message)messages[i].getHashtag().equals(keyword)) {
                          Message x = (Message)messages.get(i); 
                          mList.add(x); 
                       }
                }*/
                
                break; 
                
            default :
                break; 
        }
        return mList ; 
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

