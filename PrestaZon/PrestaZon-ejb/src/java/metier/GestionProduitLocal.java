/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import exceptions.ProduitInexistantException;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marine
 */
@Local
public interface GestionProduitLocal {
    List getProduit();
    
    String addStock(BigDecimal idProduit, int stock) throws ProduitInexistantException;
}
