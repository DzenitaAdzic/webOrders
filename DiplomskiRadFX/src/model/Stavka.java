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
public class Stavka {
    
    protected StavkaPK stavkaPK;
    
    private Integer kolicina;
 
    private String dodatniZahtjev;
  
    private Korisnik korisnik;
    
    private Narudzba narudzbaId;
    
    private JeloNaPonudi jeloNaPonudi;
    
        public Stavka() {
    }

    public Stavka(StavkaPK stavkaPK) {
        this.stavkaPK = stavkaPK;
    }

    public Stavka(int korisnikId, int dnevnaPonudaId, int jeloId) {
        this.stavkaPK = new StavkaPK(korisnikId, dnevnaPonudaId, jeloId);
    }

    public StavkaPK getStavkaPK() {
        return stavkaPK;
    }

    public void setStavkaPK(StavkaPK stavkaPK) {
        this.stavkaPK = stavkaPK;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public String getDodatniZahtjev() {
        return dodatniZahtjev;
    }

    public void setDodatniZahtjev(String dodatniZahtjev) {
        this.dodatniZahtjev = dodatniZahtjev;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Narudzba getNarudzbaId() {
        return narudzbaId;
    }

    public void setNarudzbaId(Narudzba narudzbaId) {
        this.narudzbaId = narudzbaId;
    }

    public JeloNaPonudi getJeloNaPonudi() {
        return jeloNaPonudi;
    }

    public void setJeloNaPonudi(JeloNaPonudi jeloNaPonudi) {
        this.jeloNaPonudi = jeloNaPonudi;
    }
    
    
    
}
