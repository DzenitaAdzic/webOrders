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
public class StavkaPK {
    
    private int jeloId;
    private int korisnikId;
    private int dnevnaPonudaId;
    
    
    public StavkaPK() {
    }

    public StavkaPK(int korisnikId, int dnevnaPonudaId, int jeloId) {
        this.korisnikId = korisnikId;
        this.dnevnaPonudaId = dnevnaPonudaId;
        this.jeloId = jeloId;
    }

    public int getJeloId() {
        return jeloId;
    }

    public void setJeloId(int jeloId) {
        this.jeloId = jeloId;
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
