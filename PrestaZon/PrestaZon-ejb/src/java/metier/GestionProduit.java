/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import controllers.ProduitFacadeLocal;
import entitees.Produit;
import exceptions.ProduitInexistantException;
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
public class GestionProduit implements GestionProduitLocal {
    @EJB
    private ProduitFacadeLocal produitFacade;
    
    @Override
    public List getProduit() {
        List l = new ArrayList();
        for (Produit p : produitFacade.findAll()){
            l.add("Produit : "+p.getIdproduit()+
                    "\n    Lib : "+p.getLibproduit()+
                    "\n    Stock : "+p.getStock());
        }
        return l;
    }

    @Override
    public String addStock(BigDecimal idProduit, int stock) throws ProduitInexistantException {
        String message = "addStock terminé";
        Produit p = produitFacade.find(idProduit);
        if (p==null){
            throw new ProduitInexistantException();
        }
        p.setStock(p.getStock()+stock);
        return message;
    }

 
}
