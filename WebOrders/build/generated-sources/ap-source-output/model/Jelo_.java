package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.JeloNaPonudi;
import model.Restoran;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-01T14:28:59")
@StaticMetamodel(Jelo.class)
public class Jelo_ { 

    public static volatile CollectionAttribute<Jelo, JeloNaPonudi> jeloNaPonudiCollection;
    public static volatile SingularAttribute<Jelo, String> naziv;
    public static volatile SingularAttribute<Jelo, String> jedinica;
    public static volatile SingularAttribute<Jelo, Integer> kolicina;
    public static volatile SingularAttribute<Jelo, Integer> jeloId;
    public static volatile CollectionAttribute<Jelo, Restoran> restoranCollection;

}