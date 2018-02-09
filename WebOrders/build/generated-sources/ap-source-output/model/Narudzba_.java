package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Korisnik;
import model.Restoran;
import model.Stavka;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-01T14:28:59")
@StaticMetamodel(Narudzba.class)
public class Narudzba_ { 

    public static volatile SingularAttribute<Narudzba, Integer> narudzbaId;
    public static volatile SingularAttribute<Narudzba, Restoran> restoranId;
    public static volatile CollectionAttribute<Narudzba, Stavka> stavkaCollection;
    public static volatile SingularAttribute<Narudzba, Korisnik> korisnikId;
    public static volatile SingularAttribute<Narudzba, Float> cijena;

}