package entitees;

import entitees.Commande;
import entitees.Produit;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-06T19:32:48")
@StaticMetamodel(Ligne.class)
public class Ligne_ { 

    public static volatile SingularAttribute<Ligne, BigDecimal> idligne;
    public static volatile SingularAttribute<Ligne, Commande> idcommande;
    public static volatile SingularAttribute<Ligne, Produit> idproduit;
    public static volatile SingularAttribute<Ligne, Short> quantite;

}