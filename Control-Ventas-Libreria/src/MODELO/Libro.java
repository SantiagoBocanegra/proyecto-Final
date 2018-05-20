/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ayenni42
 */
@Entity
@Table(name = "libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l")
    , @NamedQuery(name = "Libro.findByIsbn", query = "SELECT l FROM Libro l WHERE l.isbn = :isbn")
    , @NamedQuery(name = "Libro.findByTitulo", query = "SELECT l FROM Libro l WHERE l.titulo = :titulo")
    , @NamedQuery(name = "Libro.findBySipnosis", query = "SELECT l FROM Libro l WHERE l.sipnosis = :sipnosis")
    , @NamedQuery(name = "Libro.findByAutor", query = "SELECT l FROM Libro l WHERE l.autor = :autor")
    , @NamedQuery(name = "Libro.findByEditorial", query = "SELECT l FROM Libro l WHERE l.editorial = :editorial")
    , @NamedQuery(name = "Libro.findByFechaPublicacion", query = "SELECT l FROM Libro l WHERE l.fechaPublicacion = :fechaPublicacion")
    , @NamedQuery(name = "Libro.findByEstadolibro", query = "SELECT l FROM Libro l WHERE l.estadolibro = :estadolibro")
    , @NamedQuery(name = "Libro.findByPrecio", query = "SELECT l FROM Libro l WHERE l.precio = :precio")})
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "isbn")
    private Integer isbn;
    @Lob
    @Column(name = "portada")
    private byte[] portada;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "sipnosis")
    private String sipnosis;
    @Column(name = "autor")
    private String autor;
    @Column(name = "editorial")
    private String editorial;
    @Column(name = "fecha_publicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;
    @Column(name = "estadolibro")
    private String estadolibro;
    @Column(name = "precio")
    private Integer precio;
    @ManyToMany(mappedBy = "libroCollection")
    private Collection<Genero> generoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
    private Collection<Ordenitem> ordenitemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
    private Collection<Ordenitemprestamo> ordenitemprestamoCollection;

    public Libro() {
    }

    public Libro(Integer isbn) {
        this.isbn = isbn;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public byte[] getPortada() {
        return portada;
    }

    public void setPortada(byte[] portada) {
        this.portada = portada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSipnosis() {
        return sipnosis;
    }

    public void setSipnosis(String sipnosis) {
        this.sipnosis = sipnosis;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getEstadolibro() {
        return estadolibro;
    }

    public void setEstadolibro(String estadolibro) {
        this.estadolibro = estadolibro;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @XmlTransient
    public Collection<Genero> getGeneroCollection() {
        return generoCollection;
    }

    public void setGeneroCollection(Collection<Genero> generoCollection) {
        this.generoCollection = generoCollection;
    }

    @XmlTransient
    public Collection<Ordenitem> getOrdenitemCollection() {
        return ordenitemCollection;
    }

    public void setOrdenitemCollection(Collection<Ordenitem> ordenitemCollection) {
        this.ordenitemCollection = ordenitemCollection;
    }

    @XmlTransient
    public Collection<Ordenitemprestamo> getOrdenitemprestamoCollection() {
        return ordenitemprestamoCollection;
    }

    public void setOrdenitemprestamoCollection(Collection<Ordenitemprestamo> ordenitemprestamoCollection) {
        this.ordenitemprestamoCollection = ordenitemprestamoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODELO.Libro[ isbn=" + isbn + " ]";
    }
    
}
