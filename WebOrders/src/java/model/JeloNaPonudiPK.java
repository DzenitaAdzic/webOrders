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
public class JeloNaPonudiPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "jeloId")
    private int jeloId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dnevnaPonudaId")
    private int dnevnaPonudaId;

    public JeloNaPonudiPK() {
    }

    public JeloNaPonudiPK(int jeloId, int dnevnaPonudaId) {
        this.jeloId = jeloId;
        this.dnevnaPonudaId = dnevnaPonudaId;
    }

    public int getJeloId() {
        return jeloId;
    }

    public void setJeloId(int jeloId) {
        this.jeloId = jeloId;
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
        hash += (int) jeloId;
        hash += (int) dnevnaPonudaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JeloNaPonudiPK)) {
            return false;
        }
        JeloNaPonudiPK other = (JeloNaPonudiPK) object;
        if (this.jeloId != other.jeloId) {
            return false;
        }
        if (this.dnevnaPonudaId != other.dnevnaPonudaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.JeloNaPonudiPK[ jeloId=" + jeloId + ", dnevnaPonudaId=" + dnevnaPonudaId + " ]";
    }
    
}
