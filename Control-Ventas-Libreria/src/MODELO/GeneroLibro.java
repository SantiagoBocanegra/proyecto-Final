/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ayenni42
 */
@Entity
@Table(name = "genero_libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeneroLibro.findAll", query = "SELECT g FROM GeneroLibro g")
   , @NamedQuery(name = "GeneroLibro.finByLibroIsbn", query = "SELECT g FROM GeneroLibro g WHERE g.isbn.isbn = :libroIsbn")
    , @NamedQuery(name = "GeneroLibro.findByIdGenero", query = "SELECT g FROM GeneroLibro g WHERE g.idGenero = :idGenero")})
public class GeneroLibro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_genero")
    private Integer idGenero;
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne
    private Genero id;
    @JoinColumn(name = "isbn", referencedColumnName = "isbn")
    @ManyToOne
    private Libro isbn;

    public GeneroLibro() {
    }

    public GeneroLibro(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public Genero getId() {
        return id;
    }

    public void setId(Genero id) {
        this.id = id;
    }

    public Libro getIsbn() {
        return isbn;
    }

    public void setIsbn(Libro isbn) {
        this.isbn = isbn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGenero != null ? idGenero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeneroLibro)) {
            return false;
        }
        GeneroLibro other = (GeneroLibro) object;
        if ((this.idGenero == null && other.idGenero != null) || (this.idGenero != null && !this.idGenero.equals(other.idGenero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODELO.GeneroLibro[ idGenero=" + idGenero + " ]";
    }
    
}
