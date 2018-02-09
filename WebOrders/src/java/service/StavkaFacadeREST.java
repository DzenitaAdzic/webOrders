/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import model.RNarudzbe;
import model.Stavka;
import model.StavkaPK;

/**
 *
 * @author dzenita
 */
@Stateless
@Path("model.stavka")
public class StavkaFacadeREST extends AbstractFacade<Stavka> {

    @PersistenceContext(unitName = "WebOrdersPU")
    private EntityManager em;

    private StavkaPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;korisnikId=korisnikIdValue;dnevnaPonudaId=dnevnaPonudaIdValue;jeloId=jeloIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        model.StavkaPK key = new model.StavkaPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> korisnikId = map.get("korisnikId");
        if (korisnikId != null && !korisnikId.isEmpty()) {
            key.setKorisnikId(new java.lang.Integer(korisnikId.get(0)));
        }
        java.util.List<String> dnevnaPonudaId = map.get("dnevnaPonudaId");
        if (dnevnaPonudaId != null && !dnevnaPonudaId.isEmpty()) {
            key.setDnevnaPonudaId(new java.lang.Integer(dnevnaPonudaId.get(0)));
        }
        java.util.List<String> jeloId = map.get("jeloId");
        if (jeloId != null && !jeloId.isEmpty()) {
            key.setJeloId(new java.lang.Integer(jeloId.get(0)));
        }
        return key;
    }

    public StavkaFacadeREST() {
        super(Stavka.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Stavka entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") PathSegment id, Stavka entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        model.StavkaPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Stavka find(@PathParam("id") PathSegment id) {
        model.StavkaPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Stavka> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Stavka> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @GET
    @Path("/narudzba/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Stavka> findByNarudzbaId(@PathParam("id")Integer id){
        
        List<Stavka> s = em.createQuery("SELECT s FROM Stavka s WHERE s.narudzbaId.narudzbaId = :id ")
                .setParameter("id", id).getResultList();
        return s;
    
    }
    
    @GET
    @Path("/stavke/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public  List<RNarudzbe> findByStavke(@PathParam("id")Integer id){
        
        TypedQuery<Object[]> query = em.createQuery("SELECT s.dodatniZahtjev, s.kolicina, s.jeloNaPonudi.jelo.naziv, s.jeloNaPonudi.cijena, s.korisnik.username, s.korisnik.firma.naziv FROM Stavka s WHERE s.narudzbaId.narudzbaId = :id ", Object[].class)
                            .setParameter("id", id);
          List<Object[]> results = query.getResultList();
          List<RNarudzbe> ok = new ArrayList();
           for (Object[] result : results) {
               RNarudzbe r = new RNarudzbe((String)result[0],(Integer)result[1],(String) result[2], (Float)result[3], (String) result[4], (String) result[5]);
               ok.add(r);
 
                }
           return ok;  
    }
    
}

