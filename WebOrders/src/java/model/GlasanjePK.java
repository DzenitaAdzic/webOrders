/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dzenita
 */
@Embeddable
public class GlasanjePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "korisnikId")
    private int korisnikId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dnevnaPonudaId")
    private int dnevnaPonudaId;

    public GlasanjePK() {
    }

    public GlasanjePK(int korisnikId, int dnevnaPonudaId) {
        this.korisnikId = korisnikId;
        this.dnevnaPonudaId = dnevnaPonudaId;
    }

    public int getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(int korisnikId) {
        this.korisnikId = korisnikId;
    }

    public int getDnevnaPonudaId() {
        return dnevnaPonudaId;
    }

    public void setDnevnaPonudaId(int dnevnaPonudaId) {
        this.dnevnaPonudaId = dnevnaPonudaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) korisnikId;
        hash += (int) dnevnaPonudaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlasanjePK)) {
            return false;
        }
        GlasanjePK other = (GlasanjePK) object;
        if (this.korisnikId != other.korisnikId) {
            return false;
        }
        if (this.dnevnaPonudaId != other.dnevnaPonudaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.GlasanjePK[ korisnikId=" + korisnikId + ", dnevnaPonudaId=" + dnevnaPonudaId + " ]";
    }
    
}
