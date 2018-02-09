package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Firma;
import model.Glasanje;
import model.JeloNaPonudi;
import model.Restoran;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-01T14:28:59")
@StaticMetamodel(Dnevnaponuda.class)
public class Dnevnaponuda_ { 

    public static volatile SingularAttribute<Dnevnaponuda, Date> datum;
    public static volatile SingularAttribute<Dnevnaponuda, Restoran> restoranId;
    public static volatile CollectionAttribute<Dnevnaponuda, Glasanje> glasanjeCollection;
    public static volatile CollectionAttribute<Dnevnaponuda, JeloNaPonudi> jeloNaPonudiCollection;
    public static volatile SingularAttribute<Dnevnaponuda, Integer> dnevnaPonudaId;
    public static volatile SingularAttribute<Dnevnaponuda, Firma> firmaId;

}