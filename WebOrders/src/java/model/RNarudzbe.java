/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author dzenita
 */
public class RNarudzbe {
    
    private String jeloNaziv;
    private String dodatniZahtjev;
    private Integer kolicina;
    private Float cijena;
    private String username;
    private String naziv;
   

    public RNarudzbe(String dodatniZahtjev, Integer kolicina,String jeloNaziv, Float cijena, String username, String naziv) {
        this.jeloNaziv = jeloNaziv;
        this.dodatniZahtjev = dodatniZahtjev;
        this.kolicina = kolicina;
        this.cijena = cijena;
        this.username = username;
        this.naziv = naziv;
        
    }
    
    public String getJeloNaziv() {
        return jeloNaziv;
    }

    public Float getCijena() {
        return cijena;
    }

    public void setCijena(Float cijena) {
        this.cijena = cijena;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setJeloNaziv(String jeloNaziv) {
        this.jeloNaziv = jeloNaziv;
    }

    public String getDodatniZahtjev() {
        return dodatniZahtjev;
    }

    public void setDodatniZahtjev(String dodatniZahtjev) {
        this.dodatniZahtjev = dodatniZahtjev;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public RNarudzbe() {}
    public RNarudzbe(String dodatniZahtjev,Integer kolicina, String jeloNaPonudi) {
        this.jeloNaziv = jeloNaPonudi;
        this.dodatniZahtjev = dodatniZahtjev;
        this.kolicina = kolicina;
    }

  
}
