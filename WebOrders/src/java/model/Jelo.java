/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "jelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jelo.findAll", query = "SELECT j FROM Jelo j")
    , @NamedQuery(name = "Jelo.findByJeloId", query = "SELECT j FROM Jelo j WHERE j.jeloId = :jeloId")
    , @NamedQuery(name = "Jelo.findByNaziv", query = "SELECT j FROM Jelo j WHERE j.naziv = :naziv")
    , @NamedQuery(name = "Jelo.findByKolicina", query = "SELECT j FROM Jelo j WHERE j.kolicina = :kolicina")
    , @NamedQuery(name = "Jelo.findByJedinica", query = "SELECT j FROM Jelo j WHERE j.jedinica = :jedinica")})
public class Jelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "jeloId")
    private Integer jeloId;
    @Size(max = 45)
    @Column(name = "naziv")
    private String naziv;
    @Column(name = "kolicina")
    private Integer kolicina;
    @Size(max = 45)
    @Column(name = "jedinica")
    private String jedinica;
    @JoinTable(name = "restoran_jelo", joinColumns = {
        @JoinColumn(name = "jeloId", referencedColumnName = "jeloId")}, inverseJoinColumns = {
        @JoinColumn(name = "restoranId", referencedColumnName = "restoranId")})
    @ManyToMany
    private Collection<Restoran> restoranCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jelo")
    private Collection<JeloNaPonudi> jeloNaPonudiCollection;

    public Jelo() {
    }

    public Jelo(Integer jeloId) {
        this.jeloId = jeloId;
    }

    public Integer getJeloId() {
        return jeloId;
    }

    public void setJeloId(Integer jeloId) {
        this.jeloId = jeloId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public String getJedinica() {
        return jedinica;
    }

    public void setJedinica(String jedinica) {
        this.jedinica = jedinica;
    }

    @XmlTransient
    public Collection<Restoran> getRestoranCollection() {
        return restoranCollection;
    }

    public void setRestoranCollection(Collection<Restoran> restoranCollection) {
        this.restoranCollection = restoranCollection;
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
        hash += (jeloId != null ? jeloId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jelo)) {
            return false;
        }
        Jelo other = (Jelo) object;
        if ((this.jeloId == null && other.jeloId != null) || (this.jeloId != null && !this.jeloId.equals(other.jeloId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Jelo[ jeloId=" + jeloId + " ]";
    }
    
}
