/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermessagingsystemrobbins;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DanAsh4Ever
 */
public class ServerDriverTest {
    
    public ServerDriverTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ServerDriver.main(args);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRegister() {
        System.out.println("register");
        String name = "";
        String pass = "";
        ServerDriver instance = new ServerDriver();
        String expResult = "";
        String result = instance.register(name, pass);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testLogOn() {
        System.out.println("logOn");
        String name = "";
        String pass = "";
        ServerDriver instance = new ServerDriver();
        String expResult = "";
        String result = instance.logOn(name, pass);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testLogOff() {
        System.out.println("logOff");
        String name = "";
        ServerDriver instance = new ServerDriver();
        String expResult = "";
        String result = instance.logOff(name);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testFollow() {
        System.out.println("follow");
        String personDoingFollowing = "";
        String personBeingFollowed = "";
        ServerDriver instance = new ServerDriver();
        String expResult = "";
        String result = instance.follow(personDoingFollowing, personBeingFollowed);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUnfollow() {
        System.out.println("unfollow");
        String personDoingUnfollowing = "";
        String personBeingUnfollowed = "";
        ServerDriver instance = new ServerDriver();
        String expResult = "";
        String result = instance.unfollow(personDoingUnfollowing, personBeingUnfollowed);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDisplay() {
        System.out.println("display");
        String name = "";
        String type = "";
        ServerDriver instance = new ServerDriver();
        FollowList expResult = null;
        FollowList result = instance.display(name, type);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSend() {
        System.out.println("send");
        String sender = "";
        String hashtag = "";
        String message = "";
        LocalDate timestamp = null;
        ServerDriver instance = new ServerDriver();
        String expResult = "";
        String result = instance.send(sender, hashtag, message, timestamp);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRetrieve() {
        System.out.println("retrieve");
        String keyword = "";
        String name = "";
        LocalDate timestamp = null;
        ServerDriver instance = new ServerDriver();
        MessageList2 expResult = null;
        MessageList2 result = instance.retrieve(keyword, name, timestamp);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSearch() {
        System.out.println("search");
        String keyword = "";
        String name = "";
        LocalDate timestamp = null;
        ServerDriver instance = new ServerDriver();
        MessageList2 expResult = null;
        MessageList2 result = instance.search(keyword, name, timestamp);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
