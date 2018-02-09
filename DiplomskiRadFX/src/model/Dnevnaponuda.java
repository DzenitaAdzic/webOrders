/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @author dzenita
 */
public class Dnevnaponuda {
    
    private Integer dnevnaPonudaId;
    private String datum;
    private Firma firmaId;
    private Restoran restoranId;
    private Collection<Glasanje> glasanjeCollection;
    private Collection<JeloNaPonudi> jeloNaPonudiCollection;
    
    public Dnevnaponuda() {
    }

    public Dnevnaponuda(Integer dnevnaPonudaId) {
        this.dnevnaPonudaId = dnevnaPonudaId;
    }

    public Dnevnaponuda(Integer dnevnaPonudaId, String datum) {
        this.dnevnaPonudaId = dnevnaPonudaId;
        this.datum = datum;
    }

    public Integer getDnevnaPonudaId() {
        return dnevnaPonudaId;
    }

    public void setDnevnaPonudaId(Integer dnevnaPonudaId) {
        this.dnevnaPonudaId = dnevnaPonudaId;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Firma getFirmaId() {
        return firmaId;
    }

    public void setFirmaId(Firma firmaId) {
        this.firmaId = firmaId;
    }

    public Restoran getRestoranId() {
        return restoranId;
    }

    public void setRestoranId(Restoran restoranId) {
        this.restoranId = restoranId;
    }

    public Collection<Glasanje> getGlasanjeCollection() {
        return glasanjeCollection;
    }

    public void setGlasanjeCollection(Collection<Glasanje> glasanjeCollection) {
        this.glasanjeCollection = glasanjeCollection;
    }

    public Collection<JeloNaPonudi> getJeloNaPonudiCollection() {
        return jeloNaPonudiCollection;
    }

    public void setJeloNaPonudiCollection(Collection<JeloNaPonudi> jeloNaPonudiCollection) {
        this.jeloNaPonudiCollection = jeloNaPonudiCollection;
    } 
}
