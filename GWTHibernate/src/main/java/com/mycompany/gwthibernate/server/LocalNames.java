/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gwthibernate.server;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author OFesenyuk
 */
@Entity
@Table(name = "LOCAL_NAMES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocalNames.findAll", query = "SELECT l FROM LocalNames l"),
    @NamedQuery(name = "LocalNames.findById", query = "SELECT l FROM LocalNames l WHERE l.id = :id"),
    @NamedQuery(name = "LocalNames.findByName", query = "SELECT l FROM LocalNames l WHERE l.name = :name"),
    @NamedQuery(name = "LocalNames.findByLocale", query = "SELECT l FROM LocalNames l WHERE l.locale = :locale")})
public class LocalNames implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
//    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "NAME")
    private String name;
    @Size(max = 100)
    @Column(name = "LOCALE")
    private String locale;
    @JoinColumn(name = "U_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserData uId;

    public LocalNames() {
    }

    public LocalNames(Integer id) {
        this.id = id;
    }

    public LocalNames(String name, String locale) {
        this.name = name;
        this.locale = locale;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public UserData getUId() {
        return uId;
    }

    public void setUId(UserData uId) {
        this.uId = uId;
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
        if (!(object instanceof LocalNames)) {
            return false;
        }
        LocalNames other = (LocalNames) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.gwthibernate.server.LocalNames[ id=" + id + " ]";
    }
    
}
