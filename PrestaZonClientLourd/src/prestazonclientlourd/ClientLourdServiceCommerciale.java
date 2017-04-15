/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestazonclientlourd;



import exceptions.UtilisateurInconnuException;
import exceptions.UtilisateurExistantException;
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
        System.setProperty("java.naming.factory.initial",
        "com.sun.enterprise.naming.SerialInitContextFactory");
        System.setProperty("org.omg.CORBA.ORBInitialHost",
        "127.0.0.1");
        System.setProperty("org.omg.CORBA.ORBInitialPort",
        "3700");
        InitialContext context = new InitialContext();
        
        ServiceCommercialRemote souche = (ServiceCommercialRemote) context.lookup("services.ServiceCommercialRemote");
        long idCl =0;
        try {
            idCl = souche.ajoutUtilisateur("Reine", "des neige","frosen","Iceberg",56454685,"fr@wanadoo.fr",1) ;
        } catch(Exception e) {
            System.out.println("création");
        }
        System.out.println(idCl);
        
    }
}
