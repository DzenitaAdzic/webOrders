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
public class Glasanje {
    
    protected GlasanjePK glasanjePK;
    private Integer brojGlasova;
    private Dnevnaponuda dnevnaponuda;
    private Korisnik korisnik;
    
    public Glasanje() {
    }

    public Glasanje(GlasanjePK glasanjePK) {
        this.glasanjePK = glasanjePK;
    }

    public Glasanje(int korisnikId, int dnevnaPonudaId) {
        this.glasanjePK = new GlasanjePK(korisnikId, dnevnaPonudaId);
    }

    public GlasanjePK getGlasanjePK() {
        return glasanjePK;
    }

    public void setGlasanjePK(GlasanjePK glasanjePK) {
        this.glasanjePK = glasanjePK;
    }

    public Integer getBrojGlasova() {
        return brojGlasova;
    }

    public void setBrojGlasova(Integer brojGlasova) {
        this.brojGlasova = brojGlasova;
    }

    public Dnevnaponuda getDnevnaponuda() {
        return dnevnaponuda;
    }

    public void setDnevnaponuda(Dnevnaponuda dnevnaponuda) {
        this.dnevnaponuda = dnevnaponuda;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

}
