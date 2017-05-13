/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;


import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
// manque import entities ;
import entitees.Utilisateur;
//import entitees.Compte;
import controllers.UtilisateurFacadeLocal;
import exceptions.UtilisateurExistantException;
import exceptions.UtilisateurInconnuException;


/**
 *
 * @author nolwe
 */
@Stateless
public class GestionUtilisateur implements GestionUtilisateurLocal {
    
    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;

    @Override
    public long ajoutUtilisateur(String nom, String prenom, String motDePasse, String adresse, long telephone, String mail, int idCompte) throws UtilisateurExistantException {
        try {
            utilisateurFacade.chercherUtilisateur(mail);
            throw new exceptions.UtilisateurExistantException();
        } catch (UtilisateurInconnuException ex) {  
        }
        Utilisateur u = new Utilisateur();
        u.setNom(nom);
        u.setPrenom(prenom);
        u.setMotdepasse(motDePasse);
        u.setAdresse(adresse);
        u.setTelephone(telephone);
        u.setMail(mail);
        u.setIdcompte(idCompte);
        return u.getIdutilisateur().longValue();
        
    }
    
    

    @Override
    public List<Utilisateur> listeUtilisateurs() throws UtilisateurInconnuException {
            
        return utilisateurFacade.findAll();
    }

    @Override
    public void supprimer(long idUtilisateur) throws UtilisateurInconnuException {
       Utilisateur u = utilisateurFacade.find(idUtilisateur);
       if (u == null)
           throw new UtilisateurInconnuException();
       utilisateurFacade.remove(u);
    }
    

     
  
    
    
}
