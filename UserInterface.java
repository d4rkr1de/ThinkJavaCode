package textvježba;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Tomislav
 */
public class UserInterface {

    Scanner input = new Scanner(System.in);
    private Mjesec mjesec = new Mjesec();
    private Dan dan;
    List<String> sati = new ArrayList<>();

    public UserInterface() {
    }

    void run() throws IOException {
        System.out.println("Odaberi opciju:");
        System.out.println("               1. Unesi podatke za današnji datum");
        System.out.println("               2. Unesi podatke za neki drugi datum");
        System.out.println("               3. Isprintaj cijeli mjesec");
        int odabir = input.nextInt();
       switch(odabir){
           case 1: unesiSate();
           case 4: mjesec.napraviNovuListu();           
       }     
    }

    void unesiSate() {
        double pocetakRada;
        double krajRada;
        System.out.print("Unesi pocetak rada: ");
        pocetakRada = input.nextDouble();
        System.out.print("Unesi kraj rada: ");
        krajRada = input.nextDouble();
        dan = new Dan(mjesec.dajBrojDana(), pocetakRada, krajRada);
        sati.set(mjesec.date.getDay(), "dfs");
        try {
            ucitajSate();
            
        } catch (Exception e) {
        }
        
        
        try {
            ispisiUText();
            for(String str: sati){
                System.out.println(str);
            }
            
        } catch (Exception e) {
        }

    }

    void ucitajSate() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(mjesec.getPath()));
        while (scanner.hasNextLine()) {
            sati.add(scanner.nextLine());
        }
    }

    void ispisiUText() throws IOException {
        FileWriter writer = new FileWriter(mjesec.getPath());
        for (String str : sati) {
            writer.write(str);
            writer.write("\r\n");
        }
        writer.close();
    }
    //Napravi fajl sa rednim brojevima za dane za cijeli mjesec
    void pripremiMjesec(){
        sati = mjesec.novaListaSati();
        mjesec.napraviNovuListu();
    }

}
