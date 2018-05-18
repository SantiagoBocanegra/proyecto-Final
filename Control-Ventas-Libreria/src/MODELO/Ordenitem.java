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
@Table(name = "ordenitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordenitem.findAll", query = "SELECT o FROM Ordenitem o")
    , @NamedQuery(name = "Ordenitem.findByOrdencompraNumeroorden", query = "SELECT o FROM Ordenitem o WHERE o.ordenitemPK.ordencompraNumeroorden = :ordencompraNumeroorden")
    , @NamedQuery(name = "Ordenitem.findByLibroIsbn", query = "SELECT o FROM Ordenitem o WHERE o.ordenitemPK.libroIsbn = :libroIsbn")
    , @NamedQuery(name = "Ordenitem.findByCantidadorden", query = "SELECT o FROM Ordenitem o WHERE o.cantidadorden = :cantidadorden")
    , @NamedQuery(name = "Ordenitem.findByValororden", query = "SELECT o FROM Ordenitem o WHERE o.valororden = :valororden")})
public class Ordenitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenitemPK ordenitemPK;
    @Column(name = "cantidadorden")
    private Integer cantidadorden;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valororden")
    private int valororden;
    @JoinColumn(name = "libro_isbn", referencedColumnName = "isbn", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Libro libro;
    @JoinColumn(name = "ordencompra_numeroorden", referencedColumnName = "numeroorden", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ordencompra ordencompra;

    public Ordenitem() {
    }

    public Ordenitem(OrdenitemPK ordenitemPK) {
        this.ordenitemPK = ordenitemPK;
    }

    public Ordenitem(int ordencompraNumeroorden, int libroIsbn) {
        this.ordenitemPK = new OrdenitemPK(ordencompraNumeroorden, libroIsbn);
    }

    public Ordenitem(Integer cantidadorden, int valororden, Libro isbnLibro) {
        this.cantidadorden = cantidadorden;
        this.valororden = valororden;
        this.libro = isbnLibro;
    }

    public OrdenitemPK getOrdenitemPK() {
        return ordenitemPK;
    }

    public void setOrdenitemPK(OrdenitemPK ordenitemPK) {
        this.ordenitemPK = ordenitemPK;
    }

    public Integer getCantidadorden() {
        return cantidadorden;
    }

    public void setCantidadorden(Integer cantidadorden) {
        this.cantidadorden = cantidadorden;
    }

    public int getValororden() {
        return valororden;
    }

    public void setValororden(int valororden) {
        this.valororden = valororden;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Ordencompra getOrdencompra() {
        return ordencompra;
    }

    public void setOrdencompra(Ordencompra ordencompra) {
        this.ordencompra = ordencompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenitemPK != null ? ordenitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordenitem)) {
            return false;
        }
        Ordenitem other = (Ordenitem) object;
        if ((this.ordenitemPK == null && other.ordenitemPK != null) || (this.ordenitemPK != null && !this.ordenitemPK.equals(other.ordenitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODELO.Ordenitem[ ordenitemPK=" + ordenitemPK + " ]";
    }
    
}
