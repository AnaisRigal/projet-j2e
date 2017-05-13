package entitees;

import entitees.Ligne;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-13T22:34:22")
@StaticMetamodel(Produit.class)
public class Produit_ { 

    public static volatile SingularAttribute<Produit, String> nomproduit;
    public static volatile SingularAttribute<Produit, BigDecimal> prix;
    public static volatile CollectionAttribute<Produit, Ligne> ligneCollection;
    public static volatile SingularAttribute<Produit, BigDecimal> idproduit;
    public static volatile SingularAttribute<Produit, String> libproduit;

}