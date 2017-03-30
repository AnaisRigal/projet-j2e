/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitees;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nolwe
 */
@Entity
@Table(name = "LIGNE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ligne.findAll", query = "SELECT l FROM Ligne l")
    , @NamedQuery(name = "Ligne.findByIdligne", query = "SELECT l FROM Ligne l WHERE l.idligne = :idligne")
    , @NamedQuery(name = "Ligne.findByQuantite", query = "SELECT l FROM Ligne l WHERE l.quantite = :quantite")})
public class Ligne implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLIGNE")
    private BigDecimal idligne;
    @Column(name = "QUANTITE")
    private Short quantite;
    @JoinColumn(name = "IDCOMMANDE", referencedColumnName = "IDCOMMANDE")
    @ManyToOne
    private Commande idcommande;
    @JoinColumn(name = "IDPRODUIT", referencedColumnName = "IDPRODUIT")
    @ManyToOne
    private Produit idproduit;

    public Ligne() {
    }

    public Ligne(BigDecimal idligne) {
        this.idligne = idligne;
    }

    public BigDecimal getIdligne() {
        return idligne;
    }

    public void setIdligne(BigDecimal idligne) {
        this.idligne = idligne;
    }

    public Short getQuantite() {
        return quantite;
    }

    public void setQuantite(Short quantite) {
        this.quantite = quantite;
    }

    public Commande getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(Commande idcommande) {
        this.idcommande = idcommande;
    }

    public Produit getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Produit idproduit) {
        this.idproduit = idproduit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idligne != null ? idligne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ligne)) {
            return false;
        }
        Ligne other = (Ligne) object;
        if ((this.idligne == null && other.idligne != null) || (this.idligne != null && !this.idligne.equals(other.idligne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitees.Ligne[ idligne=" + idligne + " ]";
    }
    
}
