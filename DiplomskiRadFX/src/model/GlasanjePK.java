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
public class GlasanjePK {
    
    private int korisnikId;
    private int dnevnaPonudaId;
    
    public GlasanjePK() {
    }

    public GlasanjePK(int korisnikId, int dnevnaPonudaId) {
        this.korisnikId = korisnikId;
        this.dnevnaPonudaId = dnevnaPonudaId;
    }

    public int getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(int korisnikId) {
        this.korisnikId = korisnikId;
    }

    public int getDnevnaPonudaId() {
        return dnevnaPonudaId;
    }

    public void setDnevnaPonudaId(int dnevnaPonudaId) {
        this.dnevnaPonudaId = dnevnaPonudaId;
    }
    
    
    
}
