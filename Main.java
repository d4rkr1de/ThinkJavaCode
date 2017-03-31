/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textvježba;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Tomislav
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
       
       UserInterface ui = new UserInterface();
       Mjesec mjesec = new Mjesec();
       System.out.println(mjesec.dajBrojDana());
       ui.run();
       
      
    }
    
    
    
}
