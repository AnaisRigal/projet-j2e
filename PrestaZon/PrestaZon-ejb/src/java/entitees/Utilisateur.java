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
@Table(name = "UTILISATEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
    , @NamedQuery(name = "Utilisateur.findByIdutilisateur", query = "SELECT u FROM Utilisateur u WHERE u.idutilisateur = :idutilisateur")
    , @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom")
    , @NamedQuery(name = "Utilisateur.findByPrenom", query = "SELECT u FROM Utilisateur u WHERE u.prenom = :prenom")
    , @NamedQuery(name = "Utilisateur.findByMotdepasse", query = "SELECT u FROM Utilisateur u WHERE u.motdepasse = :motdepasse")
    , @NamedQuery(name = "Utilisateur.findByAdresse", query = "SELECT u FROM Utilisateur u WHERE u.adresse = :adresse")
    , @NamedQuery(name = "Utilisateur.findByTelephone", query = "SELECT u FROM Utilisateur u WHERE u.telephone = :telephone")
    , @NamedQuery(name = "Utilisateur.findByMail", query = "SELECT u FROM Utilisateur u WHERE u.mail = :mail")
    , @NamedQuery(name = "Utilisateur.findByIdcompte", query = "SELECT u FROM Utilisateur u WHERE u.idcompte = :idcompte")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUTILISATEUR")
    private BigDecimal idutilisateur;
    @Size(max = 50)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 50)
    @Column(name = "PRENOM")
    private String prenom;
    @Size(max = 50)
    @Column(name = "MOTDEPASSE")
    private String motdepasse;
    @Size(max = 200)
    @Column(name = "ADRESSE")
    private String adresse;
    @Column(name = "TELEPHONE")
    private Long telephone;
    @Size(max = 100)
    @Column(name = "MAIL")
    private String mail;
    @Column(name = "IDCOMPTE")
    private Integer idcompte;
    @OneToMany(mappedBy = "idutilisateur")
    private Collection<Commande> commandeCollection;

    public Utilisateur() {
    }

    public Utilisateur(BigDecimal idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public BigDecimal getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(BigDecimal idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getIdcompte() {
        return idcompte;
    }

    public void setIdcompte(Integer idcompte) {
        this.idcompte = idcompte;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idutilisateur != null ? idutilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idutilisateur == null && other.idutilisateur != null) || (this.idutilisateur != null && !this.idutilisateur.equals(other.idutilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitees.Utilisateur[ idutilisateur=" + idutilisateur + " ]";
    }
    
}
