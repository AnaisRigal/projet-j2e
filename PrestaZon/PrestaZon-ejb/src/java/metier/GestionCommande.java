/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import controllers.CommandeFacadeLocal;
import controllers.LigneFacadeLocal;
import controllers.ProduitFacadeLocal;
import entitees.Commande;
import entitees.Ligne;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Marine
 */
@Stateless
public class GestionCommande implements GestionCommandeLocal {
    @EJB
    private LigneFacadeLocal ligne;
    
    @EJB
    private CommandeFacadeLocal commande;

    @EJB
    private ProduitFacadeLocal produit;
    @Override
    public List afficherCommandes() {
    List a = new ArrayList();
    for (Commande c : commande.findAll()) {
        a.add(c);
        for (Ligne l : ligne.findAll()) {
            if (l.getIdcommande().getIdcommande()==c.getIdcommande()){
                 a.add(l);
            }
        }
      }
      a.addAll(ligne.findAll());
      return a;
    }

    @Override
    public String modifierCommande( BigDecimal idcommande,String etat) {
        String r = "NOK";
        Commande c = commande.find((idcommande));
        if (c!=null && ( c.getEtatcommande().equals("En cours")|| c.getEtatcommande().equals("Validée")||
          c.getEtatcommande().equals("Préparation")|| c.getEtatcommande().equals("Expédiée")||
           c.getEtatcommande().equals("Livrée")|| c.getEtatcommande().equals("Annulé"))){
         
         c.setEtatcommande(etat);
         r = "OK";
        }
        /*
        for (Ligne l : ligne.findAll()) {
            if (l.getIdligne()==idligne){
                l.setQuantite(quantite);
                l.setIdcommande(commande.find(idcommande));
                l.setIdproduit(produit.find(idproduit));
                r = "OK";
            }
        }
    */
    return r;
    }

    @Override
    public String supprimerCommande(BigDecimal idcommande) {
        String r = "NOK";
           for (Ligne l : ligne.findAll()) {
            if (l.getIdcommande().getIdcommande()==idcommande){
                ligne.remove(l);
            }
        }
        if (commande.find(idcommande)!=null){
            commande.remove(commande.find(idcommande));
            r = "OK";
        }
        return r;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
