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
public class FirmaDnevnaPonuda {
    private int idDnevnaPonuda;
    private String nazivRestorana;
    private String Adresa;
    private String brojTelefona;

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public int getIdDnevnaPonuda() {
        return idDnevnaPonuda;
    }

    public void setIdDnevnaPonuda(int idDnevnaPonuda) {
        this.idDnevnaPonuda = idDnevnaPonuda;
    }

    public String getNazivRestorana() {
        return nazivRestorana;
    }

    public void setNazivRestorana(String nazivRestorana) {
        this.nazivRestorana = nazivRestorana;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String Adresa) {
        this.Adresa = Adresa;
    }
    
    @Override
    public String toString(){
        String s = new String(this.getIdDnevnaPonuda() + " "+ this.getNazivRestorana());
        return s;
    
    }
}
