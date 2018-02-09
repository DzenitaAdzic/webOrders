/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dzenita
 */
@Entity
@Table(name = "jelo_na_ponudi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JeloNaPonudi.findAll", query = "SELECT j FROM JeloNaPonudi j")
    , @NamedQuery(name = "JeloNaPonudi.findByJeloId", query = "SELECT j FROM JeloNaPonudi j WHERE j.jeloNaPonudiPK.jeloId = :jeloId")
    , @NamedQuery(name = "JeloNaPonudi.findByDnevnaPonudaId", query = "SELECT j FROM JeloNaPonudi j WHERE j.jeloNaPonudiPK.dnevnaPonudaId = :dnevnaPonudaId")
    , @NamedQuery(name = "JeloNaPonudi.findByCijena", query = "SELECT j FROM JeloNaPonudi j WHERE j.cijena = :cijena")
    , @NamedQuery(name = "JeloNaPonudi.findByKolicina", query = "SELECT j FROM JeloNaPonudi j WHERE j.kolicina = :kolicina")
    , @NamedQuery(name = "JeloNaPonudi.findByPopust", query = "SELECT j FROM JeloNaPonudi j WHERE j.popust = :popust")})
public class JeloNaPonudi implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JeloNaPonudiPK jeloNaPonudiPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cijena")
    private Float cijena;
    @Size(max = 25)
    @Column(name = "kolicina")
    private String kolicina;
    @Column(name = "popust")
    private Integer popust;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jeloNaPonudi")
    private Collection<Stavka> stavkaCollection;
    @JoinColumn(name = "jeloId", referencedColumnName = "jeloId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Jelo jelo;
    @JoinColumn(name = "dnevnaPonudaId", referencedColumnName = "dnevnaPonudaId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dnevnaponuda dnevnaponuda;

    public JeloNaPonudi() {
    }

    public JeloNaPonudi(JeloNaPonudiPK jeloNaPonudiPK) {
        this.jeloNaPonudiPK = jeloNaPonudiPK;
    }

    public JeloNaPonudi(int jeloId, int dnevnaPonudaId) {
        this.jeloNaPonudiPK = new JeloNaPonudiPK(jeloId, dnevnaPonudaId);
    }

    public JeloNaPonudiPK getJeloNaPonudiPK() {
        return jeloNaPonudiPK;
    }

    public void setJeloNaPonudiPK(JeloNaPonudiPK jeloNaPonudiPK) {
        this.jeloNaPonudiPK = jeloNaPonudiPK;
    }

    public Float getCijena() {
        return cijena;
    }

    public void setCijena(Float cijena) {
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

    @XmlTransient
    public Collection<Stavka> getStavkaCollection() {
        return stavkaCollection;
    }

    public void setStavkaCollection(Collection<Stavka> stavkaCollection) {
        this.stavkaCollection = stavkaCollection;
    }

    public Jelo getJelo() {
        return jelo;
    }

    public void setJelo(Jelo jelo) {
        this.jelo = jelo;
    }

    public Dnevnaponuda getDnevnaponuda() {
        return dnevnaponuda;
    }

    public void setDnevnaponuda(Dnevnaponuda dnevnaponuda) {
        this.dnevnaponuda = dnevnaponuda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jeloNaPonudiPK != null ? jeloNaPonudiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JeloNaPonudi)) {
            return false;
        }
        JeloNaPonudi other = (JeloNaPonudi) object;
        if ((this.jeloNaPonudiPK == null && other.jeloNaPonudiPK != null) || (this.jeloNaPonudiPK != null && !this.jeloNaPonudiPK.equals(other.jeloNaPonudiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.JeloNaPonudi[ jeloNaPonudiPK=" + jeloNaPonudiPK + " ]";
    }
    
}
