/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textvježba;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


/**
 *
 * @author Tomislav
 */
public class Mjesec {

    private String mjesec;
    private int brojDanaUMjesecu;
    private double ukupanBrojSati;
    private double zaradeno;
    private String path;
    Calendar calendar;
    Date date = new Date();
    
    
    public Mjesec() {
        calendar = new GregorianCalendar();
        brojDanaUMjesecu = calendar.getActualMaximum(calendar.getTime().getMonth());
        path = "F:" + File.separator + "Sati" + File.separator + dajMjesecUGodini()  + ".txt";
    }

    public String dajMjesecUGodini() {
        switch (calendar.getTime().getMonth()) {
            case 0:
                return "Siječanj";
            case 1:
                return "Veljača";
            case 2:
                return "Ožujak";
            case 3:
                return "travanj";
            case 4:
                return "Svibanj";
            case 5:
                return "Lipanj";
            case 6:
                return "Srpanj";
            case 7:
                return "Kolovoz";
            case 8:
                return "Rujan";
            case 9:
                return "Listopad";
            case 10:
                return "Studeni";  
        }
        return "Prosinac";
    }
    
    void napraviNovuListu(){
        
        File file = new File(path);
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();   
            FileWriter writer = new FileWriter(path);
        for (String str : novaListaSati()) {
            writer.write(str + ".");
            writer.write("\r\n");
        }
        writer.close();           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }   
    }
 
    public String dajBrojDana(){
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        return "" + dateFormat.format(date);
    }
    //ispiši redne dane za cijeli mjesec
    public List<String> novaListaSati(){
        
        List<String> lista = new ArrayList<String>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        calendar.setTime(date);
        calendar.set(calendar.DAY_OF_MONTH, 1);
        int myMonth = calendar.get(calendar.MONTH);

        while (myMonth == calendar.get(calendar.MONTH)) {
            lista.add(dateFormat.format(calendar.getTime())); 
            calendar.add(calendar.DAY_OF_MONTH, 1);
        }
        return lista;
    }
    
    void printDaysTEST(){
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        calendar.setTime(date);
        calendar.set(calendar.DAY_OF_MONTH, 1);
        int myMonth = calendar.get(calendar.MONTH);
        
        while(myMonth == calendar.get(calendar.MONTH)){
            System.out.println(dateFormat.format(calendar.getTime()));
            calendar.add(calendar.DAY_OF_MONTH, 1);
        }
    }

    public String getPath() {
        return path;
    }

    
}
