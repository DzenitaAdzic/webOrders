package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Dnevnaponuda;
import model.Korisnik;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-01T14:28:59")
@StaticMetamodel(Firma.class)
public class Firma_ { 

    public static volatile SingularAttribute<Firma, String> brFax;
    public static volatile CollectionAttribute<Firma, Dnevnaponuda> dnevnaponudaCollection;
    public static volatile SingularAttribute<Firma, String> naziv;
    public static volatile SingularAttribute<Firma, Integer> brojTelefona;
    public static volatile SingularAttribute<Firma, String> adresa;
    public static volatile SingularAttribute<Firma, String> sifra;
    public static volatile CollectionAttribute<Firma, Korisnik> korisnikCollection;
    public static volatile SingularAttribute<Firma, String> email;
    public static volatile SingularAttribute<Firma, Integer> firmaId;

}