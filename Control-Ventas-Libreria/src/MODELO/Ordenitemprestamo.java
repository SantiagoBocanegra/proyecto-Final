/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ayenni42
 */
@Entity
@Table(name = "ordenitemprestamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordenitemprestamo.findAll", query = "SELECT o FROM Ordenitemprestamo o")
    , @NamedQuery(name = "Ordenitemprestamo.findByLibroIsbn", query = "SELECT o FROM Ordenitemprestamo o WHERE o.ordenitemprestamoPK.libroIsbn = :libroIsbn")
    , @NamedQuery(name = "Ordenitemprestamo.findByOrdenprestamoNumeroorden", query = "SELECT o FROM Ordenitemprestamo o WHERE o.ordenitemprestamoPK.ordenprestamoNumeroorden = :ordenprestamoNumeroorden")
    , @NamedQuery(name = "Ordenitemprestamo.findByEstadolibro", query = "SELECT o FROM Ordenitemprestamo o WHERE o.estadolibro = :estadolibro")})
public class Ordenitemprestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenitemprestamoPK ordenitemprestamoPK;
    @Column(name = "estadolibro")
    private String estadolibro;
    @JoinColumn(name = "libro_isbn", referencedColumnName = "isbn", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Libro libro;
    @JoinColumn(name = "ordenprestamo_numeroorden", referencedColumnName = "numeroorden", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ordenprestamo ordenprestamo;

    public Ordenitemprestamo() {
    }

    public Ordenitemprestamo(OrdenitemprestamoPK ordenitemprestamoPK) {
        this.ordenitemprestamoPK = ordenitemprestamoPK;
    }

    public Ordenitemprestamo(int libroIsbn, int ordenprestamoNumeroorden) {
        this.ordenitemprestamoPK = new OrdenitemprestamoPK(libroIsbn, ordenprestamoNumeroorden);
    }

    public OrdenitemprestamoPK getOrdenitemprestamoPK() {
        return ordenitemprestamoPK;
    }

    public void setOrdenitemprestamoPK(OrdenitemprestamoPK ordenitemprestamoPK) {
        this.ordenitemprestamoPK = ordenitemprestamoPK;
    }

    public String getEstadolibro() {
        return estadolibro;
    }

    public void setEstadolibro(String estadolibro) {
        this.estadolibro = estadolibro;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Ordenprestamo getOrdenprestamo() {
        return ordenprestamo;
    }

    public void setOrdenprestamo(Ordenprestamo ordenprestamo) {
        this.ordenprestamo = ordenprestamo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenitemprestamoPK != null ? ordenitemprestamoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordenitemprestamo)) {
            return false;
        }
        Ordenitemprestamo other = (Ordenitemprestamo) object;
        if ((this.ordenitemprestamoPK == null && other.ordenitemprestamoPK != null) || (this.ordenitemprestamoPK != null && !this.ordenitemprestamoPK.equals(other.ordenitemprestamoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODELO.Ordenitemprestamo[ ordenitemprestamoPK=" + ordenitemprestamoPK + " ]";
    }
    
}
