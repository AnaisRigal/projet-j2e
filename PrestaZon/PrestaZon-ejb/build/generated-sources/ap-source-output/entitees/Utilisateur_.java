package entitees;

import entitees.Commande;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-10T19:14:38")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ { 

    public static volatile SingularAttribute<Utilisateur, BigDecimal> idutilisateur;
    public static volatile SingularAttribute<Utilisateur, Integer> idcompte;
    public static volatile SingularAttribute<Utilisateur, String> mail;
    public static volatile SingularAttribute<Utilisateur, String> adresse;
    public static volatile SingularAttribute<Utilisateur, Long> telephone;
    public static volatile SingularAttribute<Utilisateur, String> motdepasse;
    public static volatile SingularAttribute<Utilisateur, String> nom;
    public static volatile SingularAttribute<Utilisateur, String> prenom;
    public static volatile CollectionAttribute<Utilisateur, Commande> commandeCollection;

}