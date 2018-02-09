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
public class JeloNaPonudiPK {
    
    private int jeloId;
    private  int dnevnaPonudaId;
    
    public JeloNaPonudiPK() {
    }

    public JeloNaPonudiPK(int jeloId, int dnevnaPonudaId) {
        this.jeloId = jeloId;
        this.dnevnaPonudaId = dnevnaPonudaId;
    }

    public int getJeloId() {
        return jeloId;
    }

    public void setJeloId(int jeloId) {
        this.jeloId = jeloId;
    }

    public int getDnevnaPonudaId() {
        return dnevnaPonudaId;
    }

    public void setDnevnaPonudaId(int dnevnaPonudaId) {
        this.dnevnaPonudaId = dnevnaPonudaId;
    }
    
    
}
