/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitees;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marine
 */
@Entity
@Table(name = "COMMANDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c")
    , @NamedQuery(name = "Commande.findByIdcommande", query = "SELECT c FROM Commande c WHERE c.idcommande = :idcommande")
    , @NamedQuery(name = "Commande.findByDatecommande", query = "SELECT c FROM Commande c WHERE c.datecommande = :datecommande")
    , @NamedQuery(name = "Commande.findByMontantcommande", query = "SELECT c FROM Commande c WHERE c.montantcommande = :montantcommande")
    , @NamedQuery(name = "Commande.findByEtatcommande", query = "SELECT c FROM Commande c WHERE c.etatcommande = :etatcommande")})
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCOMMANDE")
    private BigDecimal idcommande;
    @Column(name = "DATECOMMANDE")
    @Temporal(TemporalType.DATE)
    private Date datecommande;
    @Column(name = "MONTANTCOMMANDE")
    private BigDecimal montantcommande;
    @Size(max = 11)
    @Column(name = "ETATCOMMANDE")
    private String etatcommande;
    @OneToMany(mappedBy = "idcommande")
    private Collection<Ligne> ligneCollection;
    @JoinColumn(name = "IDUTILISATEUR", referencedColumnName = "IDUTILISATEUR")
    @ManyToOne
    private Utilisateur idutilisateur;

    public Commande() {
    }

    public Commande(BigDecimal idcommande) {
        this.idcommande = idcommande;
    }

    public BigDecimal getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(BigDecimal idcommande) {
        this.idcommande = idcommande;
    }

    public Date getDatecommande() {
        return datecommande;
    }

    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
    }

    public BigDecimal getMontantcommande() {
        return montantcommande;
    }

    public void setMontantcommande(BigDecimal montantcommande) {
        this.montantcommande = montantcommande;
    }

    public String getEtatcommande() {
        return etatcommande;
    }

    public void setEtatcommande(String etatcommande) {
        this.etatcommande = etatcommande;
    }

    @XmlTransient
    public Collection<Ligne> getLigneCollection() {
        return ligneCollection;
    }

    public void setLigneCollection(Collection<Ligne> ligneCollection) {
        this.ligneCollection = ligneCollection;
    }

    public Utilisateur getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Utilisateur idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcommande != null ? idcommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.idcommande == null && other.idcommande != null) || (this.idcommande != null && !this.idcommande.equals(other.idcommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitees.Commande[ idcommande=" + idcommande + " ]";
    }
    
}
