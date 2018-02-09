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
public class Firma {
    private String adresa;
    private int brojTelefona;
    private int firmaId;
    private String naziv;
    private String sifra;
    private String brFax;
    private String email;
    private List<Korisnik> zaposlenici;
    
    public Firma(){}
    
    public Firma(int firmaId){
        this.firmaId = firmaId;
    }

    public int getFirmaId() {
        return firmaId;
    }

    public void setFirmaId(int firmaId) {
        this.firmaId = firmaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(int brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getBrFax() {
        return brFax;
    }

    public void setBrFax(String brFax) {
        this.brFax = brFax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Korisnik> getZaposlenici() {
        return zaposlenici;
    }

    public void setZaposlenici(List<Korisnik> zaposlenici) {
        this.zaposlenici = zaposlenici;
    }
    
}
