/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
// manque import entities ;
import entitees.Utilisateur;
//import entitees.Compte;
import controllers.UtilisateurFacadeLocal;
import controllers.CompteFacadeLocal;


/**
 *
 * @author nolwe
 */
@Stateless
public class GestionUtilisateur {
    
    @EJB
    private CompteFacadeLocal compteFacade;

    @EJB
    private ClientFacadeLocal clientFacade;
    

    @Override
    public long creerClient(String nom, String prenom) throws exceptions.ClientExistantException {
        try {
            // si le client n'existe pas il y aura une exception
            clientFacade.chercherClient(nom, prenom);
            // ici on est sûr qu'il existe donc on lance l'exception
            throw new exceptions.ClientExistantException();
        } catch (exceptions.ClientInconnuException e) {
        }
        Client c = new Client();
        c.setNom(nom);
        c.setPrenom(prenom);
        return (long) clientFacade.create(c);
    }

    @Override
    public long chercherClient(String nom, String prenom) throws exceptions.ClientInconnuException {
        return clientFacade.chercherClient(nom, prenom);
    }

    @Override
    public List<Long> listeNumComptes(long idClient)  throws exceptions.ClientInconnuException {
        Client c = this.clientFacade.find(idClient);
        if (c == null)
            throw new exceptions.ClientInconnuException();
        ArrayList<Long> listeNC = new ArrayList<Long>();
        for (Compte compte : c.getComptes()) {
            listeNC.add(compte.getId());
        }
        return listeNC;
    }

    @Override
    public long creerCompte(long idClient) throws exceptions.ClientInconnuException  {
        Client c = this.clientFacade.find(idClient);
        if (c == null)
            throw new exceptions.ClientInconnuException();
        Compte compte = new Compte();
        compte.setClient(c);
        c.getComptes().add(compte);
        return (long) compteFacade.create(compte);
    }
    
    
}
