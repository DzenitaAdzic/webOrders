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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dzenita
 */
@Entity
@Table(name = "glasanje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Glasanje.findAll", query = "SELECT g FROM Glasanje g")
    , @NamedQuery(name = "Glasanje.findByKorisnikId", query = "SELECT g FROM Glasanje g WHERE g.glasanjePK.korisnikId = :korisnikId")
    , @NamedQuery(name = "Glasanje.findByDnevnaPonudaId", query = "SELECT g FROM Glasanje g WHERE g.glasanjePK.dnevnaPonudaId = :dnevnaPonudaId")
    , @NamedQuery(name = "Glasanje.findByBrojGlasova", query = "SELECT g FROM Glasanje g WHERE g.brojGlasova = :brojGlasova")})
public class Glasanje implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GlasanjePK glasanjePK;
    @Column(name = "broj_glasova")
    private Integer brojGlasova;
    @JoinColumn(name = "dnevnaPonudaId", referencedColumnName = "dnevnaPonudaId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dnevnaponuda dnevnaponuda;
    @JoinColumn(name = "korisnikId", referencedColumnName = "korisnikId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (glasanjePK != null ? glasanjePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Glasanje)) {
            return false;
        }
        Glasanje other = (Glasanje) object;
        if ((this.glasanjePK == null && other.glasanjePK != null) || (this.glasanjePK != null && !this.glasanjePK.equals(other.glasanjePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Glasanje[ glasanjePK=" + glasanjePK + " ]";
    }
    
}
