package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.JeloNaPonudi;
import model.Korisnik;
import model.Narudzba;
import model.StavkaPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-01T14:28:59")
@StaticMetamodel(Stavka.class)
public class Stavka_ { 

    public static volatile SingularAttribute<Stavka, JeloNaPonudi> jeloNaPonudi;
    public static volatile SingularAttribute<Stavka, String> dodatniZahtjev;
    public static volatile SingularAttribute<Stavka, Narudzba> narudzbaId;
    public static volatile SingularAttribute<Stavka, StavkaPK> stavkaPK;
    public static volatile SingularAttribute<Stavka, Integer> kolicina;
    public static volatile SingularAttribute<Stavka, Korisnik> korisnik;

}