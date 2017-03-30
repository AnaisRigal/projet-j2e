/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author nolwe
 */
@Local
public interface GestionUtilisateurLocal {
        
    long creerUtilisateur(String nom, String prenom) throws exceptions.UtilisateurExistantException;

    long chercherUtilisateur(Integer id) throws exceptions.UtilisateurInconnuException;

    List<Long> listeNumComptes(long idClient) throws exceptions.UtilisateurInconnuException;

    long creerCompte(long idClient) throws exceptions.UtilisateurInconnuException;
    
    //liste de tout les utilisateur 
    
}
