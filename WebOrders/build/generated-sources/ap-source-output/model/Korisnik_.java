package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Firma;
import model.Glasanje;
import model.Narudzba;
import model.Stavka;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-01T14:28:59")
@StaticMetamodel(Korisnik.class)
public class Korisnik_ { 

    public static volatile SingularAttribute<Korisnik, String> ime;
    public static volatile SingularAttribute<Korisnik, String> prezime;
    public static volatile CollectionAttribute<Korisnik, Narudzba> narudzbaCollection;
    public static volatile CollectionAttribute<Korisnik, Glasanje> glasanjeCollection;
    public static volatile SingularAttribute<Korisnik, String> sifra;
    public static volatile CollectionAttribute<Korisnik, Stavka> stavkaCollection;
    public static volatile SingularAttribute<Korisnik, Integer> korisnikId;
    public static volatile SingularAttribute<Korisnik, Firma> firma;
    public static volatile SingularAttribute<Korisnik, String> username;

}