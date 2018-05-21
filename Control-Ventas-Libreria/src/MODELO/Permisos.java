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
@Table(name = "permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permisos.findAll", query = "SELECT p FROM Permisos p")
    , @NamedQuery(name = "Permisos.findByIdpermisos", query = "SELECT p FROM Permisos p WHERE p.idpermisos = :idpermisos")
    ,@NamedQuery(name = "Permisos.finByRolIdPermisos", query = "SELECT p FROM Permisos p WHERE p.rolUsuarioId.id = :rolId")
    , @NamedQuery(name = "Permisos.findByNombreTabla", query = "SELECT p FROM Permisos p WHERE p.nombreTabla = :nombreTabla")
    , @NamedQuery(name = "Permisos.findByVer", query = "SELECT p FROM Permisos p WHERE p.ver = :ver")
    , @NamedQuery(name = "Permisos.findByInsertar", query = "SELECT p FROM Permisos p WHERE p.insertar = :insertar")
    , @NamedQuery(name = "Permisos.findByEditar", query = "SELECT p FROM Permisos p WHERE p.editar = :editar")
    , @NamedQuery(name = "Permisos.findByBorrar", query = "SELECT p FROM Permisos p WHERE p.borrar = :borrar")})
public class Permisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpermisos")
    private Integer idpermisos;
    @Column(name = "nombre_tabla")
    private String nombreTabla;
    @Column(name = "ver")
    private Boolean ver;
    @Column(name = "insertar")
    private Boolean insertar;
    @Column(name = "editar")
    private Boolean editar;
    @Column(name = "borrar")
    private Boolean borrar;
    @JoinColumn(name = "rol_usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RolUsuario rolUsuarioId;

    public Permisos() {
    }

    public Permisos(String nombreTabla, Boolean ver, Boolean insertar, Boolean editar, Boolean borrar) {
        this.nombreTabla = nombreTabla;
        this.ver = ver;
        this.insertar = insertar;
        this.editar = editar;
        this.borrar = borrar;
    }

    public Permisos(Integer idpermisos) {
        this.idpermisos = idpermisos;
    }

    public Integer getIdpermisos() {
        return idpermisos;
    }

    public void setIdpermisos(Integer idpermisos) {
        this.idpermisos = idpermisos;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
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

    public RolUsuario getRolUsuarioId() {
        return rolUsuarioId;
    }

    public void setRolUsuarioId(RolUsuario rolUsuarioId) {
        this.rolUsuarioId = rolUsuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpermisos != null ? idpermisos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permisos)) {
            return false;
        }
        Permisos other = (Permisos) object;
        if ((this.idpermisos == null && other.idpermisos != null) || (this.idpermisos != null && !this.idpermisos.equals(other.idpermisos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODELO.Permisos[ idpermisos=" + idpermisos + " ]";
    }
    
}
