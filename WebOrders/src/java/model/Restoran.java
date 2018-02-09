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
@Table(name = "restoran")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restoran.findAll", query = "SELECT r FROM Restoran r")
    , @NamedQuery(name = "Restoran.findByRestoranId", query = "SELECT r FROM Restoran r WHERE r.restoranId = :restoranId")
    , @NamedQuery(name = "Restoran.findByNaziv", query = "SELECT r FROM Restoran r WHERE r.naziv = :naziv")
    , @NamedQuery(name = "Restoran.findByAdresa", query = "SELECT r FROM Restoran r WHERE r.adresa = :adresa")
    , @NamedQuery(name = "Restoran.findByBrojTelefona", query = "SELECT r FROM Restoran r WHERE r.brojTelefona = :brojTelefona")
    , @NamedQuery(name = "Restoran.findBySifra", query = "SELECT r FROM Restoran r WHERE r.sifra = :sifra")
    , @NamedQuery(name = "Restoran.findByBrFaxa", query = "SELECT r FROM Restoran r WHERE r.brFaxa = :brFaxa")
    , @NamedQuery(name = "Restoran.findByEmail", query = "SELECT r FROM Restoran r WHERE r.email = :email")})
public class Restoran implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "restoranId")
    private Integer restoranId;
    @Size(max = 45)
    @Column(name = "naziv")
    private String naziv;
    @Size(max = 45)
    @Column(name = "adresa")
    private String adresa;
    @Column(name = "brojTelefona")
    private Integer brojTelefona;
    @Size(max = 45)
    @Column(name = "sifra")
    private String sifra;
    @Size(max = 45)
    @Column(name = "brFaxa")
    private String brFaxa;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @ManyToMany(mappedBy = "restoranCollection")
    private Collection<Jelo> jeloCollection;
    @OneToMany(mappedBy = "restoranId")
    private Collection<Dnevnaponuda> dnevnaponudaCollection;
    @OneToMany(mappedBy = "restoranId")
    private Collection<Narudzba> narudzbaCollection;

    public Restoran() {
    }

    public Restoran(Integer restoranId) {
        this.restoranId = restoranId;
    }

    public Integer getRestoranId() {
        return restoranId;
    }

    public void setRestoranId(Integer restoranId) {
        this.restoranId = restoranId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Integer getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(Integer brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getBrFaxa() {
        return brFaxa;
    }

    public void setBrFaxa(String brFaxa) {
        this.brFaxa = brFaxa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Jelo> getJeloCollection() {
        return jeloCollection;
    }

    public void setJeloCollection(Collection<Jelo> jeloCollection) {
        this.jeloCollection = jeloCollection;
    }

    @XmlTransient
    public Collection<Dnevnaponuda> getDnevnaponudaCollection() {
        return dnevnaponudaCollection;
    }

    public void setDnevnaponudaCollection(Collection<Dnevnaponuda> dnevnaponudaCollection) {
        this.dnevnaponudaCollection = dnevnaponudaCollection;
    }

    @XmlTransient
    public Collection<Narudzba> getNarudzbaCollection() {
        return narudzbaCollection;
    }

    public void setNarudzbaCollection(Collection<Narudzba> narudzbaCollection) {
        this.narudzbaCollection = narudzbaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (restoranId != null ? restoranId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restoran)) {
            return false;
        }
        Restoran other = (Restoran) object;
        if ((this.restoranId == null && other.restoranId != null) || (this.restoranId != null && !this.restoranId.equals(other.restoranId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Restoran[ restoranId=" + restoranId + " ]";
    }
    
}
