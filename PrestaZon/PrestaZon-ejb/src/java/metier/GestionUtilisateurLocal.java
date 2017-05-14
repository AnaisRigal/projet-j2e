/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import entitees.Utilisateur;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author nolwe
 */
@Local
public interface GestionUtilisateurLocal {
        
    BigDecimal ajoutUtilisateur(String nom, String prenom, String motDePasse, String adresse, long telephone, String mail, int idCompte) throws exceptions.UtilisateurExistantException;
    
    //long chercherUtilisateur(Integer id) throws exceptions.UtilisateurInconnuException;

    List<Utilisateur> listeUtilisateurs() throws exceptions.UtilisateurInconnuException;

    void supprimer(BigDecimal idUtilisateur) throws exceptions.UtilisateurInconnuException;
    
    //liste de tout les utilisateur 
    
    
}
