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
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;


/**
 *
 * @author nolwe
 */
@Stateless
public class GestionUtilisateur implements GestionUtilisateurLocal {
    
    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;

    @Override
    public BigDecimal ajoutUtilisateur(String nom, String prenom, String motDePasse, String adresse, long telephone, String mail, int idCompte) throws UtilisateurExistantException {
        try {
            utilisateurFacade.chercherUtilisateur(mail);
            throw new exceptions.UtilisateurExistantException();
        } catch (UtilisateurInconnuException ex) {  
        }
        Utilisateur u = new Utilisateur();
        
        u.setIdutilisateur(new BigDecimal(utilisateurFacade.findAll().size()+1));
        u.setNom(nom);
        u.setPrenom(prenom);
        u.setMotdepasse(motDePasse);
        u.setAdresse(adresse);
        u.setTelephone(telephone);
        u.setMail(mail);
        u.setIdcompte(idCompte);
        utilisateurFacade.create(u);
        return u.getIdutilisateur();
        
    }
    
    

    @Override
    public List<Utilisateur> listeUtilisateurs() throws UtilisateurInconnuException {
        List l =   new ArrayList()  ;
        if (utilisateurFacade.findAll()==null) throw new UtilisateurInconnuException();
        for (Utilisateur u : utilisateurFacade.findAll()){
            l.add("Utilisateur : "+ u.getIdutilisateur()
            +"\n    Nom : "+u.getNom()
            +"\n    Prenom : "+u.getPrenom()
            +"\n    Mail : "+u.getMail()
            +"\n    MotDePasse : "+u.getMotdepasse()
            +"\n    Adresse : "+u.getAdresse()
            +"\n    Tel : "+u.getTelephone()
            +"\n    idCompte : "+u.getIdcompte()
            +"\n\n");
        }
        return l;
    }

    @Override
    public void supprimer(BigDecimal idUtilisateur) throws UtilisateurInconnuException {
       Utilisateur u = null;
       for (Utilisateur ut : utilisateurFacade.findAll()){
           if(ut.getIdutilisateur().equals(idUtilisateur))
               u = ut;
       }
       if (u == null)
           throw new UtilisateurInconnuException();
       utilisateurFacade.remove(u);
    }
    

     
  
    
    
}
