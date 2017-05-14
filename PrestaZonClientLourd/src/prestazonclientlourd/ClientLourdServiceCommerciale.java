/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestazonclientlourd;



import exceptions.UtilisateurInconnuException;
import exceptions.UtilisateurExistantException;
import java.math.BigDecimal;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import services.ServiceCommercialRemote;


/**
 *
 * @author allan
 */
public class ClientLourdServiceCommerciale {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException, UtilisateurInconnuException, UtilisateurExistantException {
        // TODO code application logic here
        System.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");  
         System.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");  
         System.setProperty("org.omg.CORBA.ORBInitialPort", "3700"); 
         System.setProperty("java.rmi.server.codebase","file:/C:/Users/Marine/Documents/projet-j2e-testing/PrestaZon/PrestaZon-ejb/src/java/entitees");
         InitialContext context = new InitialContext(); 
        System.out.println("Service commerciale");
         ServiceCommercialRemote souche = (ServiceCommercialRemote) context.lookup("services.ServiceCommercialRemote");
      
        //java:global/PrestaZon/PrestaZon-ejb/Libraries/PrestaZonShared/services/
        //***********************************************************************************************************
        //Service Commercial : Gestion utilisateur 
        System.out.println("Test gestion utilisateur");
         // --> afficheUtilisateur               
        System.out.println(souche.listeUtilisateurs());
        
        // --> ajoutUtilisateur                
                BigDecimal idCl = new BigDecimal(5);
        try {
    //        idCl =  souche.ajoutUtilisateur("Reine", "des neige","frosen","Iceberg",56454685,"fr@wanadoo.fr",1) ;
        } catch(Exception e) {
            System.out.println("création");
        }
        System.out.println(idCl);
        
        // --> supprimerUtilisateur        
        try {
        souche.supprimer(idCl);
        } catch(Exception e) {
            System.out.println("suppression\n"+e.getMessage()+e.getClass()+e);
        }
        
        
        //***********************************************************************************************************
        //Service Commercial : Gestion Commande
        System.out.println("\n\nTest gestion commande");
        
        // --> afficherCommande
        System.out.println(souche.afficherCommandes());
        
        // --> modifierCommande
        String message;
        try {
        //  message = souche.modifierCommande(new BigDecimal(3),new Short("1"),new BigDecimal(2),new BigDecimal(2)) ;
         message = souche.modifierCommande(new BigDecimal(2),"Livrée") ;
          System.out.println(message);
        } catch(Exception e) {
            System.out.println("modification\n"+e.getMessage());
        }
   
        // --> SupprimerCommande
        try {
        message=souche.supprimerCommande(new BigDecimal(2));
        System.out.println(message);
        } catch(Exception e) {
            System.out.println("suppression\n"+e.getMessage());
        }
    }
}
