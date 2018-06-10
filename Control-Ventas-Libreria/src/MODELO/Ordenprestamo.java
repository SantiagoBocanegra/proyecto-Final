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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ordenprestamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordenprestamo.findAll", query = "SELECT o FROM Ordenprestamo o")
    , @NamedQuery(name = "Ordenprestamo.findByNumeroorden", query = "SELECT o FROM Ordenprestamo o WHERE o.numeroorden = :numeroorden")
    , @NamedQuery(name = "Ordenprestamo.findByNombreELike", query = "SELECT e FROM Ordenprestamo e WHERE LOWER(e.empleadoId.nombre) LIKE CONCAT(:nombreE,'%')")
    , @NamedQuery(name = "Ordenprestamo.findByNombreCLike", query = "SELECT e FROM Ordenprestamo e WHERE LOWER(e.clienteId.nombre) LIKE CONCAT(:nombreC,'%')") 
    , @NamedQuery(name = "Ordenprestamo.findByFechaorden", query = "SELECT o FROM Ordenprestamo o WHERE o.fechaorden = :fechaorden")
    , @NamedQuery(name = "Ordenprestamo.findByFechaentrega", query = "SELECT o FROM Ordenprestamo o WHERE o.fechaentrega = :fechaentrega")
    , @NamedQuery(name = "Ordenprestamo.findByRangoFechas", query = "SELECT a FROM Ordenprestamo a WHERE a.fechaentrega BETWEEN :fechaentregaI AND :fechaentregaF")
    , @NamedQuery(name = "Ordenprestamo.findByCantidadtotal", query = "SELECT o FROM Ordenprestamo o WHERE o.cantidadtotal = :cantidadtotal")
    , @NamedQuery(name = "Ordenprestamo.findByEstadoorden", query = "SELECT o FROM Ordenprestamo o WHERE o.estadoorden = :estadoorden")})
public class Ordenprestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numeroorden")
    private Integer numeroorden;
    @Column(name = "fechaorden")
    @Temporal(TemporalType.DATE)
    private Date fechaorden;
    @Column(name = "fechaentrega")
    @Temporal(TemporalType.DATE)
    private Date fechaentrega;
    @Column(name = "cantidadtotal")
    private Integer cantidadtotal;
    @Column(name = "multa")
    private Integer multa;
    @Column(name = "estadoorden")
    private String estadoorden;
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente clienteId;
    @JoinColumn(name = "empleado_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleado empleadoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenprestamo")
    private Collection<Ordenitemprestamo> ordenitemprestamoCollection;

    public Ordenprestamo() {
    }

    public Ordenprestamo(Integer numeroorden) {
        this.numeroorden = numeroorden;
    }

    public Integer getNumeroorden() {
        return numeroorden;
    }

    public void setNumeroorden(Integer numeroorden) {
        this.numeroorden = numeroorden;
    }

    public Date getFechaorden() {
        return fechaorden;
    }

    public void setFechaorden(Date fechaorden) {
        this.fechaorden = fechaorden;
    }

    public Date getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(Date fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public Integer getCantidadtotal() {
        return cantidadtotal;
    }

    public void setCantidadtotal(Integer cantidadtotal) {
        this.cantidadtotal = cantidadtotal;
    }

    public Integer getMulta() {
        return multa;
    }

    public void setMulta(Integer multa) {
        this.multa = multa;
    }

    public String getEstadoorden() {
        return estadoorden;
    }

    public void setEstadoorden(String estadoorden) {
        this.estadoorden = estadoorden;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public Empleado getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Empleado empleadoId) {
        this.empleadoId = empleadoId;
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
        hash += (numeroorden != null ? numeroorden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordenprestamo)) {
            return false;
        }
        Ordenprestamo other = (Ordenprestamo) object;
        if ((this.numeroorden == null && other.numeroorden != null) || (this.numeroorden != null && !this.numeroorden.equals(other.numeroorden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODELO.Ordenprestamo[ numeroorden=" + numeroorden + " ]";
    }
    
}
