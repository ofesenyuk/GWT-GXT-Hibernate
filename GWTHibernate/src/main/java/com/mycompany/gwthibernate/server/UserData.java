/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gwthibernate.server;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author OFesenyuk
 */
@Entity
@Table(name = "USER_DATA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserData.findAll", query = "SELECT u FROM UserData u"),
    @NamedQuery(name = "UserData.findById", query = "SELECT u FROM UserData u WHERE u.id = :id"),
    @NamedQuery(name = "UserData.findByName", query = "SELECT u FROM UserData u WHERE u.name = :name")})
public class UserData implements Serializable {
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
    @Lob
    @Column(name = "USER_NAME")
    private byte[] userName;
    @Lob
    @Column(name = "PASSWORD")
    private byte[] password;
    @OneToMany(mappedBy = "uId", fetch = FetchType.LAZY)
    private Collection<LocalNames> localNamesCollection;

    public UserData() {
    }

    public UserData(Integer id) {
        this.id = id;
    }

    public UserData(String name, byte[] userName, byte[] password, 
            Collection<LocalNames> localNamesCollection) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.localNamesCollection = localNamesCollection;
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

    public byte[] getUserName() {
        return userName;
    }

    public void setUserName(byte[] userName) {
        this.userName = userName;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<LocalNames> getLocalNamesCollection() {
        return localNamesCollection;
    }

    public void setLocalNamesCollection(Collection<LocalNames> localNamesCollection) {
        this.localNamesCollection = localNamesCollection;
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
        if (!(object instanceof UserData)) {
            return false;
        }
        UserData other = (UserData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.gwthibernate.server.UserData[ id=" + id + " ]";
    }
    
}
