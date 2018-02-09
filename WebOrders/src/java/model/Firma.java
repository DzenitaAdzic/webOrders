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
@Table(name = "firma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Firma.findAll", query = "SELECT f FROM Firma f")
    , @NamedQuery(name = "Firma.findByFirmaId", query = "SELECT f FROM Firma f WHERE f.firmaId = :firmaId")
    , @NamedQuery(name = "Firma.findByNaziv", query = "SELECT f FROM Firma f WHERE f.naziv = :naziv")
    , @NamedQuery(name = "Firma.findByBrojTelefona", query = "SELECT f FROM Firma f WHERE f.brojTelefona = :brojTelefona")
    , @NamedQuery(name = "Firma.findByAdresa", query = "SELECT f FROM Firma f WHERE f.adresa = :adresa")
    , @NamedQuery(name = "Firma.findBySifra", query = "SELECT f FROM Firma f WHERE f.sifra = :sifra")
    , @NamedQuery(name = "Firma.findByBrFax", query = "SELECT f FROM Firma f WHERE f.brFax = :brFax")
    , @NamedQuery(name = "Firma.findByEmail", query = "SELECT f FROM Firma f WHERE f.email = :email")})
public class Firma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "firmaId")
    private Integer firmaId;
    @Size(max = 45)
    @Column(name = "naziv")
    private String naziv;
    @Column(name = "brojTelefona")
    private Integer brojTelefona;
    @Size(max = 45)
    @Column(name = "adresa")
    private String adresa;
    @Size(max = 45)
    @Column(name = "sifra")
    private String sifra;
    @Size(max = 45)
    @Column(name = "brFax")
    private String brFax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "firmaId")
    private Collection<Dnevnaponuda> dnevnaponudaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "firma")
    private Collection<Korisnik> korisnikCollection;

    public Firma() {
    }

    public Firma(Integer firmaId) {
        this.firmaId = firmaId;
    }

    public Integer getFirmaId() {
        return firmaId;
    }

    public void setFirmaId(Integer firmaId) {
        this.firmaId = firmaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(Integer brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getBrFax() {
        return brFax;
    }

    public void setBrFax(String brFax) {
        this.brFax = brFax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Dnevnaponuda> getDnevnaponudaCollection() {
        return dnevnaponudaCollection;
    }

    public void setDnevnaponudaCollection(Collection<Dnevnaponuda> dnevnaponudaCollection) {
        this.dnevnaponudaCollection = dnevnaponudaCollection;
    }

    @XmlTransient
    public Collection<Korisnik> getKorisnikCollection() {
        return korisnikCollection;
    }

    public void setKorisnikCollection(Collection<Korisnik> korisnikCollection) {
        this.korisnikCollection = korisnikCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (firmaId != null ? firmaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Firma)) {
            return false;
        }
        Firma other = (Firma) object;
        if ((this.firmaId == null && other.firmaId != null) || (this.firmaId != null && !this.firmaId.equals(other.firmaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Firma[ firmaId=" + firmaId + " ]";
    }
    
}
