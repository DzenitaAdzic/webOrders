package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Dnevnaponuda;
import model.Jelo;
import model.JeloNaPonudiPK;
import model.Stavka;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-01T14:28:59")
@StaticMetamodel(JeloNaPonudi.class)
public class JeloNaPonudi_ { 

    public static volatile SingularAttribute<JeloNaPonudi, JeloNaPonudiPK> jeloNaPonudiPK;
    public static volatile SingularAttribute<JeloNaPonudi, String> kolicina;
    public static volatile SingularAttribute<JeloNaPonudi, Integer> popust;
    public static volatile CollectionAttribute<JeloNaPonudi, Stavka> stavkaCollection;
    public static volatile SingularAttribute<JeloNaPonudi, Dnevnaponuda> dnevnaponuda;
    public static volatile SingularAttribute<JeloNaPonudi, Float> cijena;
    public static volatile SingularAttribute<JeloNaPonudi, Jelo> jelo;

}