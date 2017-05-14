/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import controllers.CommandeFacadeLocal;
import controllers.LigneFacadeLocal;
import controllers.ProduitFacadeLocal;
import controllers.UtilisateurFacadeLocal;
import entitees.Commande;
import entitees.Ligne;
import entitees.Utilisateur;
import exceptions.CommandeInexistanteException;
import exceptions.UtilisateurInconnuException;
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
public class GestionCommande implements GestionCommandeLocal  {
    @EJB
    private LigneFacadeLocal ligne;
    
    @EJB
    private CommandeFacadeLocal commande;

    @EJB
    private ProduitFacadeLocal produit;
    
    @EJB
    private UtilisateurFacadeLocal utilisateur;
    @Override
    public List afficherCommandes() {
    List a = new ArrayList();
    for (Commande c : commande.findAll()) {
        a.add("Commande : "+c.getIdcommande()+" - "+c.getDatecommande()+" - "+c.getMontantcommande()+" - "+c.getIdutilisateur().getIdutilisateur()+" - "+c.getEtatcommande());
        for (Ligne l : ligne.findAll()) {
            if (l.getIdcommande().getIdcommande()==c.getIdcommande()){
                 a.add("\n     Ligne"+l.getIdligne()+" - "+l.getIdproduit()+" - "+l.getQuantite());
            }
            
        }
        a.add("\n\n");
        
      }
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

    @Override
    public List<Utilisateur> afficherLivraison() throws UtilisateurInconnuException {
        List list = new ArrayList<Utilisateur>();
        Utilisateur u = null;
        for (Commande c : commande.findAll()){
            if(c.getEtatcommande().equals("Expédiée")){
                u = utilisateur.find(c.getIdutilisateur());
                if (u==null) throw new UtilisateurInconnuException();
                list.add(u);
            }
        }
        return list;
    }

    @Override
    public String changerLivraison(BigDecimal idcommande, String etat) throws CommandeInexistanteException {
        String r = "NOK";
        Commande c = commande.find((idcommande));
        if (c==null  ) throw new CommandeInexistanteException();
        if (c.getEtatcommande().equals("En cours")|| c.getEtatcommande().equals("Validée")||
          c.getEtatcommande().equals("Préparation")|| c.getEtatcommande().equals("Expédiée")||
           c.getEtatcommande().equals("Livrée")|| c.getEtatcommande().equals("Annulé")){
            c.setEtatcommande(etat);
            r = "OK";
        }
        return r;
    }

    @Override
    public List consulterCommandes(BigDecimal idUtilisateur) throws UtilisateurInconnuException {
        List list = new ArrayList();
        for (Commande c : commande.findAll()){
            if (c.getIdutilisateur().getIdutilisateur().equals(idUtilisateur)){
                list.add("Commande : "+c.getIdcommande()+" - "+c.getDatecommande()+" - "+c.getMontantcommande()+" - "+c.getIdutilisateur().getIdutilisateur()+" - "+c.getEtatcommande());
                for (Ligne l : ligne.findAll()) {
                    if (l.getIdcommande().getIdcommande()==c.getIdcommande()){
                         list.add("\n     Ligne"+l.getIdligne()+" - "+l.getIdproduit()+" - "+l.getQuantite());
                    }

                }
                list.add("\n\n");
            }
        }
        if (list.size()==0) throw new UtilisateurInconnuException();
        return list;
    }
}
