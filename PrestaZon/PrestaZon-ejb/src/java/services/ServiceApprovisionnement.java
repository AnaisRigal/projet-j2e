/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import exceptions.ProduitInexistantException;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import metier.GestionCommandeLocal;
import metier.GestionProduitLocal;

/**
 *
 * @author Marine
 */
@Stateless
public class ServiceApprovisionnement implements ServiceApprovisionnementRemote {
    @EJB
    private GestionProduitLocal gestionProduit;
    
    @Override
    public List getStocks() {
        return gestionProduit.getProduit();
    }

    @Override
    public String addStock(BigDecimal idProduit, int stock) throws ProduitInexistantException {
        return gestionProduit.addStock(idProduit, stock);
    }

}
