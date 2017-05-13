/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import exceptions.UtilisateurExistantException;
import exceptions.UtilisateurInconnuException;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import metier.GestionCommandeLocal;
import metier.GestionUtilisateur;
import metier.GestionUtilisateurLocal;

/**
 *
 * @author allan
 */
@Stateless 
public class ServiceCommercial implements ServiceCommercialRemote {
    @EJB
    private GestionUtilisateurLocal g;
    
    @EJB
    private GestionCommandeLocal c;
    
    @Override
    public long ajoutUtilisateur(String nom, String prenom, String motDePasse, String adresse, long telephone, String mail, int idCompte) throws UtilisateurExistantException {
        return g.ajoutUtilisateur(nom, prenom, motDePasse, adresse, telephone, mail, idCompte);
    }

    @Override
    public List listeUtilisateurs() throws UtilisateurInconnuException {
        return g.listeUtilisateurs();
    }

    @Override
    public void supprimer(long idUtilisateur) throws UtilisateurInconnuException {
        g.supprimer(idUtilisateur);
    }

    @Override
    public List afficherCommandes() {
        return c.afficherCommandes();
    }

   /* @Override
    public String modifierCommande(BigDecimal idligne, Short quantite, BigDecimal idcommande, BigDecimal idproduit) {
        return c.modifierCommande(idligne, quantite, idcommande, idproduit);
    }
*/
    @Override
    public String modifierCommande( BigDecimal idcommande, String etat) {
        return c.modifierCommande(idcommande,etat);
    }

    @Override
    public String supprimerCommande(BigDecimal idcommande) {
        return c.supprimerCommande(idcommande);
    }
    
    

}
