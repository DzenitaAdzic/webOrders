package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Dnevnaponuda;
import model.GlasanjePK;
import model.Korisnik;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-01T14:28:59")
@StaticMetamodel(Glasanje.class)
public class Glasanje_ { 

    public static volatile SingularAttribute<Glasanje, Integer> brojGlasova;
    public static volatile SingularAttribute<Glasanje, GlasanjePK> glasanjePK;
    public static volatile SingularAttribute<Glasanje, Dnevnaponuda> dnevnaponuda;
    public static volatile SingularAttribute<Glasanje, Korisnik> korisnik;

}