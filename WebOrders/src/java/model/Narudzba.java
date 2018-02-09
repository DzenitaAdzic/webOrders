/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dzenita
 */
@Entity
@Table(name = "narudzba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Narudzba.findAll", query = "SELECT n FROM Narudzba n")
    , @NamedQuery(name = "Narudzba.findByNarudzbaId", query = "SELECT n FROM Narudzba n WHERE n.narudzbaId = :narudzbaId")
    , @NamedQuery(name = "Narudzba.findByCijena", query = "SELECT n FROM Narudzba n WHERE n.cijena = :cijena")})
public class Narudzba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "narudzbaId")
    private Integer narudzbaId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cijena")
    private Float cijena;
    @OneToMany(mappedBy = "narudzbaId")
    private Collection<Stavka> stavkaCollection;
    @JoinColumn(name = "korisnikId", referencedColumnName = "korisnikId")
    @ManyToOne
    private Korisnik korisnikId;
    @JoinColumn(name = "restoranId", referencedColumnName = "restoranId")
    @ManyToOne
    private Restoran restoranId;

    public Narudzba() {
    }

    public Narudzba(Integer narudzbaId) {
        this.narudzbaId = narudzbaId;
    }

    public Integer getNarudzbaId() {
        return narudzbaId;
    }

    public void setNarudzbaId(Integer narudzbaId) {
        this.narudzbaId = narudzbaId;
    }

    public Float getCijena() {
        return cijena;
    }

    public void setCijena(Float cijena) {
        this.cijena = cijena;
    }

    @XmlTransient
    public Collection<Stavka> getStavkaCollection() {
        return stavkaCollection;
    }

    public void setStavkaCollection(Collection<Stavka> stavkaCollection) {
        this.stavkaCollection = stavkaCollection;
    }

    public Korisnik getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Korisnik korisnikId) {
        this.korisnikId = korisnikId;
    }

    public Restoran getRestoranId() {
        return restoranId;
    }

    public void setRestoranId(Restoran restoranId) {
        this.restoranId = restoranId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (narudzbaId != null ? narudzbaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Narudzba)) {
            return false;
        }
        Narudzba other = (Narudzba) object;
        if ((this.narudzbaId == null && other.narudzbaId != null) || (this.narudzbaId != null && !this.narudzbaId.equals(other.narudzbaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Narudzba[ narudzbaId=" + narudzbaId + " ]";
    }
    
}
