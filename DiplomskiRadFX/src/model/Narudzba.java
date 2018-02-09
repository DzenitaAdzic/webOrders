/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Collection;

/**
 *
 * @author dzenita
 */
public class Narudzba {
    
    private Integer narudzbaId;
    
    private Float cijena;
    
    private Collection<Stavka> stavkaCollection;
    
    private Korisnik korisnikId;
 
    private Restoran restoranId;

    public Integer getNarudzbaId() {
        return narudzbaId;
    }

    public void setNarudzbaId(Integer narudzbaId) {
        this.narudzbaId = narudzbaId;
    }

    public Float getCijena() {
        return cijena;
    }

    public void setCijena(Float cijena) {
        this.cijena = cijena;
    }

    public Collection<Stavka> getStavkaCollection() {
        return stavkaCollection;
    }

    public void setStavkaCollection(Collection<Stavka> stavkaCollection) {
        this.stavkaCollection = stavkaCollection;
    }

    public Korisnik getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Korisnik korisnikId) {
        this.korisnikId = korisnikId;
    }

    public Restoran getRestoranId() {
        return restoranId;
    }

    public void setRestoranId(Restoran restoranId) {
        this.restoranId = restoranId;
    }
    
    
    
}
