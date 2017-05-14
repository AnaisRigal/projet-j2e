/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestazonclientlourd;

import exceptions.CommandeInexistanteException;
import exceptions.UtilisateurExistantException;
import exceptions.UtilisateurInconnuException;
import java.math.BigDecimal;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import services.ServiceCommercialRemote;
import services.ServiceLivraisonRemote;

/**
 *
 * @author Marine
 */
public class ClientLourdServiceLivraison {
    public static void main(String[] args) throws NamingException, UtilisateurInconnuException, UtilisateurExistantException, CommandeInexistanteException {
        // TODO code application logic here
        System.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");  
         System.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");  
         System.setProperty("org.omg.CORBA.ORBInitialPort", "3700"); 
         System.setProperty("java.rmi.server.codebase","file:/C:/Users/Marine/Documents/projet-j2e-testing/PrestaZon/PrestaZon-ejb/src/java/entitees");
         InitialContext context = new InitialContext(); 
        System.out.println("Service Livraison");
         ServiceLivraisonRemote souche = (ServiceLivraisonRemote) context.lookup("services.ServiceLivraisonRemote");
      
        //afficherCommande
        
        System.out.println(souche.afficherLivraison());
        
        
        //changerLivraison
        System.out.println(souche.changerLivraison(new BigDecimal(3),"Livrée"));
        
    }
}
