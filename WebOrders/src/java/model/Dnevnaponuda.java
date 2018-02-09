/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dzenita
 */
@Entity
@Table(name = "dnevnaponuda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dnevnaponuda.findAll", query = "SELECT d FROM Dnevnaponuda d")
    , @NamedQuery(name = "Dnevnaponuda.findByDnevnaPonudaId", query = "SELECT d FROM Dnevnaponuda d WHERE d.dnevnaPonudaId = :dnevnaPonudaId")
    , @NamedQuery(name = "Dnevnaponuda.findByDatum", query = "SELECT d FROM Dnevnaponuda d WHERE d.datum = :datum")})
public class Dnevnaponuda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dnevnaPonudaId")
    private Integer dnevnaPonudaId;
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @JoinColumn(name = "firmaId", referencedColumnName = "firmaId")
    @ManyToOne
    private Firma firmaId;
    @JoinColumn(name = "restoranId", referencedColumnName = "restoranId")
    @ManyToOne
    private Restoran restoranId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dnevnaponuda")
    private Collection<Glasanje> glasanjeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dnevnaponuda")
    private Collection<JeloNaPonudi> jeloNaPonudiCollection;

    public Dnevnaponuda() {
    }

    public Dnevnaponuda(Integer dnevnaPonudaId) {
        this.dnevnaPonudaId = dnevnaPonudaId;
    }

    public Integer getDnevnaPonudaId() {
        return dnevnaPonudaId;
    }

    public void setDnevnaPonudaId(Integer dnevnaPonudaId) {
        this.dnevnaPonudaId = dnevnaPonudaId;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
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

    @XmlTransient
    public Collection<Glasanje> getGlasanjeCollection() {
        return glasanjeCollection;
    }

    public void setGlasanjeCollection(Collection<Glasanje> glasanjeCollection) {
        this.glasanjeCollection = glasanjeCollection;
    }

    @XmlTransient
    public Collection<JeloNaPonudi> getJeloNaPonudiCollection() {
        return jeloNaPonudiCollection;
    }

    public void setJeloNaPonudiCollection(Collection<JeloNaPonudi> jeloNaPonudiCollection) {
        this.jeloNaPonudiCollection = jeloNaPonudiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dnevnaPonudaId != null ? dnevnaPonudaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dnevnaponuda)) {
            return false;
        }
        Dnevnaponuda other = (Dnevnaponuda) object;
        if ((this.dnevnaPonudaId == null && other.dnevnaPonudaId != null) || (this.dnevnaPonudaId != null && !this.dnevnaPonudaId.equals(other.dnevnaPonudaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Dnevnaponuda[ dnevnaPonudaId=" + dnevnaPonudaId + " ]";
    }
    
}
