/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Collection;
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
import model.Dnevnaponuda;
import model.Firma;
import model.Korisnik;

/**
 *
 * @author dzenita
 */
@Stateless
@Path("model.firma")
public class FirmaFacadeREST extends AbstractFacade<Firma> {

    @PersistenceContext(unitName = "WebOrdersPU")
    private EntityManager em;

    public FirmaFacadeREST() {
        super(Firma.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Firma entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Firma entity) {
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
    public Firma find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Firma> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Firma> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("/naziv/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Firma findByNaziv(@PathParam("username")String username){
    
       Firma f = (Firma) em.createNamedQuery("Firma.findByNaziv").setParameter("naziv", username).getSingleResult();
       
       return f;
    }
    
    @GET
    @Path("{id}/zaposlenici")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Korisnik> getZaposlenici(@PathParam("id")Integer id){
    
    Firma f = find(id);
    em.refresh(f);
    return f.getKorisnikCollection();
    
    }
    
    @GET
    @Path("{id}/dnevnePonude")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Dnevnaponuda> getDnevnePonude(@PathParam("id")Integer id){
    /*
    Firma f = find(id);
    em.refresh(f);
    return f.getDnevnaponudaCollection();
*/
    List<Dnevnaponuda> ok = em.createQuery("SELECT d FROM Dnevnaponuda d where d.firmaId.firmaId =:id AND d.datum = CURRENT_DATE")
            .setParameter("id", id).getResultList();
    return ok;
    }
    
}
