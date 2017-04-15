/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author allan
 */
@Remote
public interface ServiceCommercialRemote {
        long ajoutUtilisateur(String nom, String prenom, String motDePasse, String adresse, long telephone, String mail, int idCompte) throws exceptions.UtilisateurExistantException;
    

    List listeUtilisateurs() throws exceptions.UtilisateurInconnuException;

    void supprimer(long idUtilisateur) throws exceptions.UtilisateurInconnuException;
}
