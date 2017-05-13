/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import exceptions.CommandeInexistanteException;
import exceptions.UtilisateurInconnuException;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import metier.GestionCommandeLocal;

/**
 *
 * @author Marine
 */
@Stateless
public class ServiceLivraison implements ServiceLivraisonRemote {
@EJB
private GestionCommandeLocal gestionCommande ;

    @Override
    public List afficherLivraison() throws UtilisateurInconnuException {
        return gestionCommande.afficherCommandes();
    }

    @Override
    public String changerLivraison(BigDecimal idcommande, String etat) throws CommandeInexistanteException {
       return gestionCommande.changerLivraison(idcommande, etat);
    }

}
