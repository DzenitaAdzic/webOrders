/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dzenita
 */
@Entity
@Table(name = "stavka")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stavka.findAll", query = "SELECT s FROM Stavka s")
    , @NamedQuery(name = "Stavka.findByKorisnikId", query = "SELECT s FROM Stavka s WHERE s.stavkaPK.korisnikId = :korisnikId")
    , @NamedQuery(name = "Stavka.findByDnevnaPonudaId", query = "SELECT s FROM Stavka s WHERE s.stavkaPK.dnevnaPonudaId = :dnevnaPonudaId")
    , @NamedQuery(name = "Stavka.findByJeloId", query = "SELECT s FROM Stavka s WHERE s.stavkaPK.jeloId = :jeloId")
    , @NamedQuery(name = "Stavka.findByKolicina", query = "SELECT s FROM Stavka s WHERE s.kolicina = :kolicina")
    , @NamedQuery(name = "Stavka.findByDodatniZahtjev", query = "SELECT s FROM Stavka s WHERE s.dodatniZahtjev = :dodatniZahtjev")})
public class Stavka implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StavkaPK stavkaPK;
    @Column(name = "kolicina")
    private Integer kolicina;
    @Size(max = 45)
    @Column(name = "dodatniZahtjev")
    private String dodatniZahtjev;
    @JoinColumn(name = "korisnikId", referencedColumnName = "korisnikId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Korisnik korisnik;
    @JoinColumn(name = "narudzbaId", referencedColumnName = "narudzbaId")
    @ManyToOne
    private Narudzba narudzbaId;
    @JoinColumns({
        @JoinColumn(name = "dnevnaPonudaId", referencedColumnName = "dnevnaPonudaId", insertable = false, updatable = false)
        , @JoinColumn(name = "jeloId", referencedColumnName = "jeloId", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stavkaPK != null ? stavkaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stavka)) {
            return false;
        }
        Stavka other = (Stavka) object;
        if ((this.stavkaPK == null && other.stavkaPK != null) || (this.stavkaPK != null && !this.stavkaPK.equals(other.stavkaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Stavka[ stavkaPK=" + stavkaPK + " ]";
    }
    
}
