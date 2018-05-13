/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ayenni42
 */
@Embeddable
public class OrdenitemPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ordencompra_numeroorden")
    private int ordencompraNumeroorden;
    @Basic(optional = false)
    @Column(name = "libro_isbn")
    private int libroIsbn;

    public OrdenitemPK() {
    }

    public OrdenitemPK(int ordencompraNumeroorden, int libroIsbn) {
        this.ordencompraNumeroorden = ordencompraNumeroorden;
        this.libroIsbn = libroIsbn;
    }

    public int getOrdencompraNumeroorden() {
        return ordencompraNumeroorden;
    }

    public void setOrdencompraNumeroorden(int ordencompraNumeroorden) {
        this.ordencompraNumeroorden = ordencompraNumeroorden;
    }

    public int getLibroIsbn() {
        return libroIsbn;
    }

    public void setLibroIsbn(int libroIsbn) {
        this.libroIsbn = libroIsbn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ordencompraNumeroorden;
        hash += (int) libroIsbn;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenitemPK)) {
            return false;
        }
        OrdenitemPK other = (OrdenitemPK) object;
        if (this.ordencompraNumeroorden != other.ordencompraNumeroorden) {
            return false;
        }
        if (this.libroIsbn != other.libroIsbn) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODELO.OrdenitemPK[ ordencompraNumeroorden=" + ordencompraNumeroorden + ", libroIsbn=" + libroIsbn + " ]";
    }
    
}
