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
import model.JeloNaPonudi;
import model.Restoran;

/**
 *
 * @author dzenita
 */
@Stateless
@Path("model.dnevnaponuda")
public class DnevnaponudaFacadeREST extends AbstractFacade<Dnevnaponuda> {

    @PersistenceContext(unitName = "WebOrdersPU")
    private EntityManager em;

    public DnevnaponudaFacadeREST() {
        super(Dnevnaponuda.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Dnevnaponuda entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Dnevnaponuda entity) {
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
    public Dnevnaponuda find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dnevnaponuda> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dnevnaponuda> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("{id}/jelaNaPonudi")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<JeloNaPonudi> findJelaNaPonudi(@PathParam("id") Integer id) {
        Dnevnaponuda dp = find(id);
        em.refresh(dp);
        return dp.getJeloNaPonudiCollection();   
    }
    
    @GET
    @Path("restoranId/{restoranId}/firmaId/{firmaId}")
    public Integer zadnjaDnevnaPonuda(@PathParam("restoranId")Integer restoranId, @PathParam("firmaId")Integer firmaId){
        
        List<Dnevnaponuda> dp = em.createQuery("SELECT d from Dnevnaponuda d WHERE d.firmaId.firmaId = :firmaId AND d.restoranId.restoranId =:restoranId")
                .setParameter("firmaId", firmaId).setParameter("restoranId",restoranId).getResultList();
        int size = dp.size();
       
    return dp.get(size-1).getDnevnaPonudaId();
    }
    
    @GET
    @Path("/firma/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dnevnaponuda> ok(@PathParam("id")Integer id){
        
    List<Dnevnaponuda> ok = em.createQuery("SELECT d FROM Dnevnaponuda d where d.firmaId.firmaId =:id AND d.datum = CURRENT_DATE")
            .setParameter("id", id).getResultList();
    return ok;
    }
    
    @GET
    @Path("/restoranId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Restoran getRestoran(@PathParam("id")Integer id){
        
    Restoran ok =(Restoran) em.createQuery("SELECT d.restoranId FROM Dnevnaponuda d where d.dnevnaPonudaId = :id")
            .setParameter("id", id).getSingleResult();
    return ok;
    }
    
}
