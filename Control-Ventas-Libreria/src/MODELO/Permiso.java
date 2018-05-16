/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ayenni42
 */
@Entity
@Table(name = "permiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p")
    , @NamedQuery(name = "Permiso.findById", query = "SELECT p FROM Permiso p WHERE p.id = :id")
    , @NamedQuery(name = "Permiso.findByNombretabla", query = "SELECT p FROM Permiso p WHERE p.nombretabla = :nombretabla")
    , @NamedQuery(name = "Permiso.findByActualizar", query = "SELECT p FROM Permiso p WHERE p.actualizar = :actualizar")
    , @NamedQuery(name = "Permiso.findByEditar", query = "SELECT p FROM Permiso p WHERE p.editar = :editar")
    , @NamedQuery(name = "Permiso.findByVer", query = "SELECT p FROM Permiso p WHERE p.ver = :ver")
    , @NamedQuery(name = "Permiso.findByBorrar", query = "SELECT p FROM Permiso p WHERE p.borrar = :borrar")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombretabla")
    private String nombretabla;
    @Column(name = "actualizar")
    private Boolean actualizar;
    @Column(name = "editar")
    private Boolean editar;
    @Column(name = "ver")
    private Boolean ver;
    @Column(name = "borrar")
    private Boolean borrar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permiso")
    private Collection<RolUsuario> rolUsuarioCollection;

    public Permiso() {
    }

    public Permiso(Integer id) {
        this.id = id;
    }

    public Permiso(String nombretabla, Boolean actualizar, Boolean editar, Boolean ver) {
        this.nombretabla = nombretabla;
        this.actualizar = actualizar;
        this.editar = editar;
        this.ver = ver;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombretabla() {
        return nombretabla;
    }

    public void setNombretabla(String nombretabla) {
        this.nombretabla = nombretabla;
    }

    public Boolean getActualizar() {
        return actualizar;
    }

    public void setActualizar(Boolean actualizar) {
        this.actualizar = actualizar;
    }

    public Boolean getEditar() {
        return editar;
    }

    public void setEditar(Boolean editar) {
        this.editar = editar;
    }

    public Boolean getVer() {
        return ver;
    }

    public void setVer(Boolean ver) {
        this.ver = ver;
    }

    public Boolean getBorrar() {
        return borrar;
    }

    public void setBorrar(Boolean borrar) {
        this.borrar = borrar;
    }

    @XmlTransient
    public Collection<RolUsuario> getRolUsuarioCollection() {
        return rolUsuarioCollection;
    }

    public void setRolUsuarioCollection(Collection<RolUsuario> rolUsuarioCollection) {
        this.rolUsuarioCollection = rolUsuarioCollection;
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
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODELO.Permiso[ id=" + id + " ]";
    }
    
}
