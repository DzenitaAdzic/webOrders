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
public class Korisnik {
    private Firma firma = new Firma();
    private String ime;
    private int korisnikId;
    private String prezime;
    private String sifra;
    private String username;
    
  
     
    public Korisnik(){}
    
    public Korisnik(int id)
    {
    this.korisnikId = id;
    }

    public int getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(int korisnikId) {
        this.korisnikId = korisnikId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String password) {
        this.sifra = password;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma; 
    }
     
    public String toString(){
        return ime +" " +  prezime ;
    }
}
