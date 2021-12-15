

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a-a-robbins
 */
public class GUIDriver {
     public static void main(String[] args) {
//      TEST: see if adding stuff will change build version
//      System.out.println("Test in main at ServerDriver --- Delete me!");
       
       //create a new homepage frame (which everything else will be generated from)
        UserHomepageFrame homePage = new UserHomepageFrame();
        homePage.setVisible(true);
        //TEST: did we reach end of main?
//        System.out.println("End of main reached"); 
    }
    
    
}
