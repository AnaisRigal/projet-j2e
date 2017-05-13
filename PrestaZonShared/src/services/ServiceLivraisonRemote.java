/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import exceptions.CommandeInexistanteException;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Marine
 */
@Remote
public interface ServiceLivraisonRemote {
     List afficherLivraison() throws exceptions.UtilisateurInconnuException;
    
    String changerLivraison (BigDecimal idcommande, String etat  ) throws CommandeInexistanteException;
}
