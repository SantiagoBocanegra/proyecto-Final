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
@Table(name = "ordencompra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordencompra.findAll", query = "SELECT o FROM Ordencompra o")
    , @NamedQuery(name = "Ordencompra.findByNumeroorden", query = "SELECT o FROM Ordencompra o WHERE o.numeroorden = :numeroorden")
    , @NamedQuery(name = "Ordencompra.findByFechaorden", query = "SELECT o FROM Ordencompra o WHERE o.fechaorden = :fechaorden")
    , @NamedQuery(name = "Ordencompra.findByCantidadtotal", query = "SELECT o FROM Ordencompra o WHERE o.cantidadtotal = :cantidadtotal")
    , @NamedQuery(name = "Ordencompra.findByPreciototal", query = "SELECT o FROM Ordencompra o WHERE o.preciototal = :preciototal")})
public class Ordencompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numeroorden")
    private Integer numeroorden;
    @Column(name = "fechaorden")
    @Temporal(TemporalType.DATE)
    private Date fechaorden;
    @Column(name = "cantidadtotal")
    private Integer cantidadtotal;
    @Column(name = "preciototal")
    private Integer preciototal;
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente clienteId;
    @JoinColumn(name = "empleado_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleado empleadoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordencompra")
    private Collection<Ordenitem> ordenitemCollection;

    public Ordencompra() {
    }

    public Ordencompra(Integer numeroorden) {
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

    public Integer getCantidadtotal() {
        return cantidadtotal;
    }

    public void setCantidadtotal(Integer cantidadtotal) {
        this.cantidadtotal = cantidadtotal;
    }

    public Integer getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(Integer preciototal) {
        this.preciototal = preciototal;
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
    public Collection<Ordenitem> getOrdenitemCollection() {
        return ordenitemCollection;
    }

    public void setOrdenitemCollection(Collection<Ordenitem> ordenitemCollection) {
        this.ordenitemCollection = ordenitemCollection;
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
        if (!(object instanceof Ordencompra)) {
            return false;
        }
        Ordencompra other = (Ordencompra) object;
        if ((this.numeroorden == null && other.numeroorden != null) || (this.numeroorden != null && !this.numeroorden.equals(other.numeroorden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODELO.Ordencompra[ numeroorden=" + numeroorden + " ]";
    }
    
}
