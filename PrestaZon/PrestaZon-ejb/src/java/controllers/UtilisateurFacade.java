/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entitees.Utilisateur;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author nolwe
 */
@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> implements UtilisateurFacadeLocal {

    @PersistenceContext(unitName = "PrestaZon-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }

    @Override
    public BigDecimal chercherUtilisateur(String mail) throws exceptions.UtilisateurInconnuException {
        try {
            Query q = em.createQuery(
               "select u from Utilisateur u where u.mail = :mail");
            q.setParameter("mail", mail);
            Utilisateur c = (Utilisateur) q.getSingleResult();
            return c.getIdutilisateur();
        } catch(NoResultException e) {
            throw new exceptions.UtilisateurInconnuException();
        }        
    }
    
}
