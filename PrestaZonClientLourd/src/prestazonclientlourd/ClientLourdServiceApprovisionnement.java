/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestazonclientlourd;

import com.sun.appserv.security.ProgrammaticLogin;
import exceptions.ProduitInexistantException;
import exceptions.UtilisateurExistantException;
import exceptions.UtilisateurInconnuException;
import java.math.BigDecimal;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import services.ServiceApprovisionnementRemote;
import services.ServiceCommercialRemote;

/**
 *
 * @author Marine
 */
public class ClientLourdServiceApprovisionnement {
     public static void main(String[] args) throws NamingException, UtilisateurInconnuException, UtilisateurExistantException, ProduitInexistantException {
        // TODO code application logic here
        System.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");  
         System.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");  
         System.setProperty("org.omg.CORBA.ORBInitialPort", "3700"); 
        System.setProperty("java.rmi.server.codebase","file:/C:/Users/Marine/Documents/projet-j2e-testing/PrestaZon/PrestaZon-ejb/src/java/entitees");
        /*System.setProperty("java.security.auth.login.config","C:/Users/Marine/Documents/projet-j2e-testing/lib/appclientlogin.conf");
        ProgrammaticLogin pl = new ProgrammaticLogin();
         Boolean login = pl.login("admin", "");
         System.out.println(login);
*/
        //   System.setProperty(Context.SECURITY_PRINCIPAL, "Guest");  System.setProperty(Context.SECURITY_CREDENTIALS, "Guest");
//Now lookup the EJB and then logout


        InitialContext context = new InitialContext(); 
        System.out.println("Service approvisionnement");
         ServiceApprovisionnementRemote souche = (ServiceApprovisionnementRemote) context.lookup("services.ServiceApprovisionnementRemote");
         
         //afficherStock
         System.out.println(souche.getStocks());
         
         //afficherStock
         System.out.println(souche.addStock(new BigDecimal(3), 1));
         
     }


}
