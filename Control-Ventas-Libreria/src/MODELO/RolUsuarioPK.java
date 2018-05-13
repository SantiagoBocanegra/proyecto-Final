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
public class RolUsuarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "usuario_id")
    private int usuarioId;
    @Basic(optional = false)
    @Column(name = "permiso_id")
    private int permisoId;

    public RolUsuarioPK() {
    }

    public RolUsuarioPK(int usuarioId, int permisoId) {
        this.usuarioId = usuarioId;
        this.permisoId = permisoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getPermisoId() {
        return permisoId;
    }

    public void setPermisoId(int permisoId) {
        this.permisoId = permisoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuarioId;
        hash += (int) permisoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolUsuarioPK)) {
            return false;
        }
        RolUsuarioPK other = (RolUsuarioPK) object;
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        if (this.permisoId != other.permisoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODELO.RolUsuarioPK[ usuarioId=" + usuarioId + ", permisoId=" + permisoId + " ]";
    }
    
}
