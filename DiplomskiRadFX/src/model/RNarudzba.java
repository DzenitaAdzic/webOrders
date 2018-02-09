/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dzenita
 */
public class RNarudzba {
    
    private String ime;
    private String firmaNaziv;
    private String jeloNaziv;
    private String kolicina;
    private String cijena;
    private String dodatniZahtjev;
    private String narudzbaId;

    public String getNarudzbaId() {
        return narudzbaId;
    }

    public void setNarudzbaId(String narudzbaId) {
        this.narudzbaId = narudzbaId;
    }
    

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getFirmaNaziv() {
        return firmaNaziv;
    }

    public void setFirmaNaziv(String firmaNaziv) {
        this.firmaNaziv = firmaNaziv;
    }

    public String getJeloNaziv() {
        return jeloNaziv;
    }

    public void setJeloNaziv(String jeloNaziv) {
        this.jeloNaziv = jeloNaziv;
    }

    public String getKolicina() {
        return kolicina;
    }

    public void setKolicina(String kolicina) {
        this.kolicina = kolicina;
    }

    public String getCijena() {
        return cijena;
    }

    public void setCijena(String cijena) {
        this.cijena = cijena;
    }

    public String getDodatniZahtjev() {
        return dodatniZahtjev;
    }

    public void setDodatniZahtjev(String dodatniZahtjev) {
        this.dodatniZahtjev = dodatniZahtjev;
    }
    
    
}
