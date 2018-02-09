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
public class JeloNaPonudi {
    
    protected String jeloId;
    
    private String cijena;
    private String kolicina;
    private Integer popust;
    private String jelo;
    private String jedinica;
    private String dodatniZahtjev;
    private String dnevnaPonudaId;

    public String getDnevnaPonudaId() {
        return dnevnaPonudaId;
    }

    public void setDnevnaPonudaId(String dnevnaPonudaId) {
        this.dnevnaPonudaId = dnevnaPonudaId;
    }
    

    public String getDodatniZahtjev() {
        return dodatniZahtjev;
    }

    public void setDodatniZahtjev(String dodatniZahtjev) {
        this.dodatniZahtjev = dodatniZahtjev;
    }
   
    
     public JeloNaPonudi() {
    }

    public String getJedinica() {
        return jedinica;
    }

    public void setJedinica(String jedinica) {
        this.jedinica = jedinica;
    }
    

    public String getJeloId() {
        return jeloId;
    }

    public void setJeloId(String jeloId) {
        this.jeloId = jeloId;
    }

    

    public String getCijena() {
        return cijena;
    }

    public void setCijena(String cijena) {
        this.cijena = cijena;
    }

    public String getKolicina() {
        return kolicina;
    }

    public void setKolicina(String kolicina) {
        this.kolicina = kolicina;
    }

    public Integer getPopust() {
        return popust;
    }

    public void setPopust(Integer popust) {
        this.popust = popust;
    }

   

    public String getJelo() {
        return jelo;
    }

    public void setJelo(String jelo) {
        this.jelo = jelo;
    } 
    @Override
    public String toString(){
        String s = new String(jelo + " \t\t " + kolicina + "\t\t "+ cijena + " KM " );
    return  s;
    }
    
    
}
