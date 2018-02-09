/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Narudzba;

/**
 *
 * @author dzenita
 */
@Stateless
@Path("model.narudzba")
public class NarudzbaFacadeREST extends AbstractFacade<Narudzba> {

    @PersistenceContext(unitName = "WebOrdersPU")
    private EntityManager em;

    public NarudzbaFacadeREST() {
        super(Narudzba.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Narudzba entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Narudzba entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Narudzba find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Narudzba> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Narudzba> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
   @Path("/korisnik/{korisnikId}/restoran/{restoranId}")
   public int findByKorisnikId(@PathParam("korisnikId")Integer korisnikId, @PathParam("restoranId")Integer restoranId){
       Narudzba n = (Narudzba)em.createQuery("SELECT n FROM Narudzba n WHERE n.korisnikId.korisnikId = :korisnikId AND n.restoranId.restoranId = :restoranId")
               .setParameter("korisnikId", korisnikId).setParameter("restoranId", restoranId).getSingleResult();
       return n.getNarudzbaId();
   }
    
}
