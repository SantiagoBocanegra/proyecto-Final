/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    , @NamedQuery(name = "RolUsuario.findByUsuarioId", query = "SELECT r FROM RolUsuario r WHERE r.rolUsuarioPK.usuarioId = :usuarioId")
    , @NamedQuery(name = "RolUsuario.findByPermisoId", query = "SELECT r FROM RolUsuario r WHERE r.rolUsuarioPK.permisoId = :permisoId")
    , @NamedQuery(name = "RolUsuario.findByTiporol", query = "SELECT r FROM RolUsuario r WHERE r.tiporol = :tiporol")
    , @NamedQuery(name = "RolUsuario.findByFechacreacion", query = "SELECT r FROM RolUsuario r WHERE r.fechacreacion = :fechacreacion")})
public class RolUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RolUsuarioPK rolUsuarioPK;
    @Column(name = "tiporol")
    private String tiporol;
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @JoinColumn(name = "permiso_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Permiso permiso;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public RolUsuario() {
    }

    public RolUsuario(RolUsuarioPK rolUsuarioPK) {
        this.rolUsuarioPK = rolUsuarioPK;
    }

    public RolUsuario(int usuarioId, int permisoId) {
        this.rolUsuarioPK = new RolUsuarioPK(usuarioId, permisoId);
    }

    public RolUsuario(String tiporol, Date fechacreacion) {
        this.tiporol = tiporol;
        this.fechacreacion = fechacreacion;
    }
    
    public RolUsuarioPK getRolUsuarioPK() {
        return rolUsuarioPK;
    }

    public void setRolUsuarioPK(RolUsuarioPK rolUsuarioPK) {
        this.rolUsuarioPK = rolUsuarioPK;
    }

    public String getTiporol() {
        return tiporol;
    }

    public void setTiporol(String tiporol) {
        this.tiporol = tiporol;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolUsuarioPK != null ? rolUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolUsuario)) {
            return false;
        }
        RolUsuario other = (RolUsuario) object;
        if ((this.rolUsuarioPK == null && other.rolUsuarioPK != null) || (this.rolUsuarioPK != null && !this.rolUsuarioPK.equals(other.rolUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODELO.RolUsuario[ rolUsuarioPK=" + rolUsuarioPK + " ]";
    }
    
}
