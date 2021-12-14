
import java.util.ArrayList;


/**
 *
 * @author a-a-robbins
 */

//create a user on the GUI to store important information
public class GUIUser {
    
    private String name; 
    private String pass; 
    private String address; //FIXME: how do we get the address??
    private boolean status; 
    private ArrayList<String> messages; 
    
    public GUIUser(String name) {
        this.name = name; 
        this.status = true;
        //keep a list of public messages the user has sent during current session
        messages = new ArrayList<String>(); 
    }
    
    public void setName(String n) {
        name = n; 
    }
    
    public String getAddress() {
        return address; 
    }
    
    public String getName() {
        return name; 
    }
    
    public String getPass() {
        return pass; 
    }
    
    public boolean checkStatus() {
        return status; 
    }
    
    public boolean setStatus(boolean stat) {
        status = stat;
            //TEST: invalid log off
            //status = true; 
        return status; 
    }
   
    public void addMessage(String m) {
        messages.add(m); 
    }
    
    public ArrayList getMessages() {
        return messages; 
    }
}
