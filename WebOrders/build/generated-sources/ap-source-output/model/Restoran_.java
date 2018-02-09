package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Dnevnaponuda;
import model.Jelo;
import model.Narudzba;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-01T14:28:59")
@StaticMetamodel(Restoran.class)
public class Restoran_ { 

    public static volatile SingularAttribute<Restoran, Integer> restoranId;
    public static volatile CollectionAttribute<Restoran, Dnevnaponuda> dnevnaponudaCollection;
    public static volatile CollectionAttribute<Restoran, Narudzba> narudzbaCollection;
    public static volatile CollectionAttribute<Restoran, Jelo> jeloCollection;
    public static volatile SingularAttribute<Restoran, String> brFaxa;
    public static volatile SingularAttribute<Restoran, String> naziv;
    public static volatile SingularAttribute<Restoran, String> adresa;
    public static volatile SingularAttribute<Restoran, Integer> brojTelefona;
    public static volatile SingularAttribute<Restoran, String> sifra;
    public static volatile SingularAttribute<Restoran, String> email;

}