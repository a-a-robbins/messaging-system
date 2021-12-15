
package servermessagingsystemrobbins;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author a-a-robbins
 */

//keep a list of Message objects
public class MessageList2 {
    private ArrayList <Message> list;
    private LocalDate readTime; 
    private static final String UNREAD = "UNREAD"; 
    private static final String REFRESH = "REFRESH";
    
    MessageList2(){
        list = new ArrayList();
    }
    
//add message to list    
public String send(String sender, String hashtag, String message, LocalDate timestamp) {
    Message m = new Message(sender, hashtag, message, timestamp); 
    list.add(m); 

    return "Message sent successfully"; 
}

//retrieve messages from list based on criteria
public MessageList2 retrieve(String keyword, FollowList sender, LocalDate timestamp) {
    MessageList2 mList = new MessageList2();
    
//    //TEST: what was our keyword
//    System.out.println("Keyword = " + keyword); 
   
    switch(keyword){
        
        //retrieve all messages prior to or equal to current LocalDate
        case UNREAD :
            readTime = LocalDate.now(); 
            String[] followList = new String[sender.size()]; 
            for(int i = 0; i < sender.size(); i++) {
                followList[i] = sender.get(i); 
//                //TEST: what is our list
//                System.out.println("list[" + i + "] is: " + followList[i]); 
            }
//            //TEST: do we have a message list
//            System.out.println(list.size()); 
            for(int i = 0; i < list.size(); i++) {
               Message m = list.get(i);
//               //TEST: what is our message
//               System.out.println("Message m = " + m.getMessage());
               for(int j = 0; j < followList.length; j++) {
                   if(followList[j].equals(m.getSender())) {
                       if(m.getTimestamp().isBefore(LocalDate.now()) || (m.getTimestamp().isEqual(LocalDate.now()))) {
                           mList.add(m); 
                       }
                   }
               }
            }
   
            return mList; 
        
        //retrieve only messages between the time user got UNREAD messages and now
        case REFRESH :
            followList = new String[sender.size()]; 
            for(int i = 0; i < sender.size(); i++) {
                followList[i] = sender.get(i); 
            }
            for(int i = 0; i < list.size(); i++) {
               Message m = list.get(i);
               for(int j = 0; j < followList.length; j++) {
                   if(followList[j].equals(m.getSender())) {
                       if(m.getTimestamp().isAfter(readTime) && ((m.getTimestamp().isEqual(LocalDate.now())) || (m.getTimestamp().isBefore(LocalDate.now())))) {
                           mList.add(m); 
                       }
                   }
               }
            }
   
            return mList;
            
    }
    return mList; 
}

    //retrieve messages based on a search of hashtag and sender
    public MessageList2 search(String keyword, LocalDate timestamp) {
        MessageList2 searchList = new MessageList2(); 
        for(int i = 0; i < list.size(); i++) {
                Message m = list.get(i); 
                if((m.getHashtag().equals(keyword)) || ((m.getSender().equals(keyword)))) {
                    searchList.add(m); 
                    //TEST: see our searchList message
                    //System.out.println("searchList[" + i + "] = " + searchList.get(i)); 
                }
              
            }
//        //TEST: what size is our searchList
//        System.out.println("searchList size = " + searchList.size()); 
        return searchList; 
    }

    //add messages to our arraylist
    public void add(Message m) {
        list.add(m); 
    }

    //return size of arraylist
    public int size() {
        return list.size(); 
    }
    
    //return message at specified index
    public String get(int index ) {
        Message m = list.get(index); 
        String message = m.buildString(); 
        return message; 
    }

}
