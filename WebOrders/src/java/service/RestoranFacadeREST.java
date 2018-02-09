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
import model.Jelo;
import model.Narudzba;
import model.Restoran;

/**
 *
 * @author dzenita
 */
@Stateless
@Path("model.restoran")
public class RestoranFacadeREST extends AbstractFacade<Restoran> {

    @PersistenceContext(unitName = "WebOrdersPU")
    private EntityManager em;

    public RestoranFacadeREST() {
        super(Restoran.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Restoran entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Restoran entity) {
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
    public Restoran find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Restoran> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Restoran> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    public Restoran findByNaziv(@PathParam("username")String username){
    
       Restoran r = (Restoran) em.createNamedQuery("Restoran.findByNaziv").setParameter("naziv", username).getSingleResult();
       
       return r;
    }
    
    @GET
    @Path("/{id}/meni")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Jelo> getMeni(@PathParam("id")Integer id){
    
      Restoran r = (Restoran) em.createNamedQuery("Restoran.findByRestoranId").setParameter("restoranId", id).getSingleResult();
      em.refresh(r);
      return r.getJeloCollection();
    }
    
    @GET
    @Path("/narudzbe/{restoranId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Narudzba> getNarudzba(@PathParam("restoranId")Integer restoranId){
    
      Restoran r = (Restoran) em.createNamedQuery("Restoran.findByRestoranId").setParameter("restoranId", restoranId).getSingleResult();
      return r.getNarudzbaCollection();
    }
    
}
