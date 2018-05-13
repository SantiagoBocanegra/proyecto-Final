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
public class OrdenitemprestamoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "libro_isbn")
    private int libroIsbn;
    @Basic(optional = false)
    @Column(name = "ordenprestamo_numeroorden")
    private int ordenprestamoNumeroorden;

    public OrdenitemprestamoPK() {
    }

    public OrdenitemprestamoPK(int libroIsbn, int ordenprestamoNumeroorden) {
        this.libroIsbn = libroIsbn;
        this.ordenprestamoNumeroorden = ordenprestamoNumeroorden;
    }

    public int getLibroIsbn() {
        return libroIsbn;
    }

    public void setLibroIsbn(int libroIsbn) {
        this.libroIsbn = libroIsbn;
    }

    public int getOrdenprestamoNumeroorden() {
        return ordenprestamoNumeroorden;
    }

    public void setOrdenprestamoNumeroorden(int ordenprestamoNumeroorden) {
        this.ordenprestamoNumeroorden = ordenprestamoNumeroorden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) libroIsbn;
        hash += (int) ordenprestamoNumeroorden;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenitemprestamoPK)) {
            return false;
        }
        OrdenitemprestamoPK other = (OrdenitemprestamoPK) object;
        if (this.libroIsbn != other.libroIsbn) {
            return false;
        }
        if (this.ordenprestamoNumeroorden != other.ordenprestamoNumeroorden) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODELO.OrdenitemprestamoPK[ libroIsbn=" + libroIsbn + ", ordenprestamoNumeroorden=" + ordenprestamoNumeroorden + " ]";
    }
    
}
