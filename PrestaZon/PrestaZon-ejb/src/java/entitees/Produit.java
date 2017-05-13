/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitees;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author Marine
 */
@Entity
@Table(name = "PRODUIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p")
    , @NamedQuery(name = "Produit.findByIdproduit", query = "SELECT p FROM Produit p WHERE p.idproduit = :idproduit")
    , @NamedQuery(name = "Produit.findByNomproduit", query = "SELECT p FROM Produit p WHERE p.nomproduit = :nomproduit")
    , @NamedQuery(name = "Produit.findByLibproduit", query = "SELECT p FROM Produit p WHERE p.libproduit = :libproduit")
    , @NamedQuery(name = "Produit.findByPrix", query = "SELECT p FROM Produit p WHERE p.prix = :prix")})
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPRODUIT")
    private BigDecimal idproduit;
    @Size(max = 50)
    @Column(name = "NOMPRODUIT")
    private String nomproduit;
    @Size(max = 100)
    @Column(name = "LIBPRODUIT")
    private String libproduit;
    @Column(name = "PRIX")
    private BigDecimal prix;
    @OneToMany(mappedBy = "idproduit")
    private Collection<Ligne> ligneCollection;

    public Produit() {
    }

    public Produit(BigDecimal idproduit) {
        this.idproduit = idproduit;
    }

    public BigDecimal getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(BigDecimal idproduit) {
        this.idproduit = idproduit;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public String getLibproduit() {
        return libproduit;
    }

    public void setLibproduit(String libproduit) {
        this.libproduit = libproduit;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    @XmlTransient
    public Collection<Ligne> getLigneCollection() {
        return ligneCollection;
    }

    public void setLigneCollection(Collection<Ligne> ligneCollection) {
        this.ligneCollection = ligneCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproduit != null ? idproduit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.idproduit == null && other.idproduit != null) || (this.idproduit != null && !this.idproduit.equals(other.idproduit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitees.Produit[ idproduit=" + idproduit + " ]";
    }
    
}
