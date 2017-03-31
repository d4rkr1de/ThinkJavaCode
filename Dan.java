/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textvježba;



/**
 *
 * @author Tomislav
 */
public class Dan {
    private double pocetakRada;
    private double krajRada;
    private double brojSatiDana;

    public Dan(String danUMjesecu, double pocetakRada, double krajRada) {
        
        this.pocetakRada = pocetakRada;
        this.krajRada = krajRada;
        this.brojSatiDana = krajRada - pocetakRada;
        
    }
    
    public String toString(){
        return ""  + pocetakRada + "-" + krajRada + "     " 
                + brojSatiDana + "h";
    }
}
