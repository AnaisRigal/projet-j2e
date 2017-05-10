package entitees;

import entitees.Ligne;
import entitees.Utilisateur;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-10T19:14:38")
@StaticMetamodel(Commande.class)
public class Commande_ { 

    public static volatile SingularAttribute<Commande, Utilisateur> idutilisateur;
    public static volatile SingularAttribute<Commande, Date> datecommande;
    public static volatile SingularAttribute<Commande, BigDecimal> idcommande;
    public static volatile SingularAttribute<Commande, BigDecimal> montantcommande;
    public static volatile CollectionAttribute<Commande, Ligne> ligneCollection;

}