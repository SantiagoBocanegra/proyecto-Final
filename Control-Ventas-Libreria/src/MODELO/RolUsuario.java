/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ayenni42
 */
@Entity
@Table(name = "rol_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolUsuario.findAll", query = "SELECT r FROM RolUsuario r")
    , @NamedQuery(name = "RolUsuario.findById", query = "SELECT r FROM RolUsuario r WHERE r.id = :id")
    , @NamedQuery(name = "RolUsuario.findByNombrerol", query = "SELECT r FROM RolUsuario r WHERE r.nombrerol = :nombrerol")
    , @NamedQuery(name = "RolUsuario.findByFechacreacion", query = "SELECT r FROM RolUsuario r WHERE r.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "RolUsuario.findByNombretabla", query = "SELECT r FROM RolUsuario r WHERE r.nombretabla = :nombretabla")
    , @NamedQuery(name = "RolUsuario.findByVer", query = "SELECT r FROM RolUsuario r WHERE r.ver = :ver")
    , @NamedQuery(name = "RolUsuario.findByInsertar", query = "SELECT r FROM RolUsuario r WHERE r.insertar = :insertar")
    , @NamedQuery(name = "RolUsuario.findByEditar", query = "SELECT r FROM RolUsuario r WHERE r.editar = :editar")
    , @NamedQuery(name = "RolUsuario.findByBorrar", query = "SELECT r FROM RolUsuario r WHERE r.borrar = :borrar")})
public class RolUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombrerol")
    private String nombrerol;
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @Column(name = "nombretabla")
    private String nombretabla;
    @Column(name = "ver")
    private Boolean ver;
    @Column(name = "insertar")
    private Boolean insertar;
    @Column(name = "editar")
    private Boolean editar;
    @Column(name = "borrar")
    private Boolean borrar;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public RolUsuario() {
    }

    public RolUsuario(Integer id) {
        this.id = id;
    }

    public RolUsuario(String nombrerol, Date fechacreacion, Usuario usuarioId) {
        this.nombrerol = nombrerol;
        this.fechacreacion = fechacreacion;
        this.usuarioId = usuarioId;
    }

    public RolUsuario(String nombretabla, Boolean ver, Boolean insertar, Boolean editar, Boolean borrar) {
        this.nombretabla = nombretabla;
        this.ver = ver;
        this.insertar = insertar;
        this.editar = editar;
        this.borrar = borrar;
    }
    
    public RolUsuario(String nombrerol, Date fechacreacion, String nombretabla, Boolean ver, Boolean insertar, Boolean editar, Boolean borrar, Usuario usuarioId) {
        this.nombrerol = nombrerol;
        this.fechacreacion = fechacreacion;
        this.nombretabla = nombretabla;
        this.ver = ver;
        this.insertar = insertar;
        this.editar = editar;
        this.borrar = borrar;
        this.usuarioId = usuarioId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getNombretabla() {
        return nombretabla;
    }

    public void setNombretabla(String nombretabla) {
        this.nombretabla = nombretabla;
    }

    public Boolean getVer() {
        return ver;
    }

    public void setVer(Boolean ver) {
        this.ver = ver;
    }

    public Boolean getInsertar() {
        return insertar;
    }

    public void setInsertar(Boolean insertar) {
        this.insertar = insertar;
    }

    public Boolean getEditar() {
        return editar;
    }

    public void setEditar(Boolean editar) {
        this.editar = editar;
    }

    public Boolean getBorrar() {
        return borrar;
    }

    public void setBorrar(Boolean borrar) {
        this.borrar = borrar;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolUsuario)) {
            return false;
        }
        RolUsuario other = (RolUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODELO.RolUsuario[ id=" + id + " ]";
    }
    
}
