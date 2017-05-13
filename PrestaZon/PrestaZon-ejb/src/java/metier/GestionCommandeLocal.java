/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;
/**
 *
 * @author Marine
 */
@Local
public interface GestionCommandeLocal {
    List afficherCommandes();
    
    String modifierCommande ( BigDecimal idligne, Short quantite, BigDecimal idcommande, BigDecimal idproduit  );

    String supprimerCommande (BigDecimal idcommande);
    
}