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
import model.Jelo;
import model.Restoran;

/**
 *
 * @author dzenita
 */
@Stateless
@Path("model.jelo")
public class JeloFacadeREST extends AbstractFacade<Jelo> {

    @PersistenceContext(unitName = "WebOrdersPU")
    private EntityManager em;

    public JeloFacadeREST() {
        super(Jelo.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Jelo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Jelo entity) {
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
    public Jelo find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Jelo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Jelo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
    @PUT
    @Path("/{id}/meni")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addMeni(@PathParam("id")Integer id, Jelo jelo){
    
       Jelo j = (Jelo) em.createNamedQuery("Jelo.findByJeloId").setParameter("jeloId", jelo.getJeloId()).getSingleResult();
       Restoran r = new Restoran(id);
       j.getRestoranCollection().add(r);
       edit(id, j);    
    }
    
    @PUT
    @Path("/{id}/restoran/{restoranId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteFromMeni(@PathParam("id")Integer id, @PathParam("restoranId")Integer restoranId, Restoran r){
    
       Jelo j = (Jelo) em.createNamedQuery("Jelo.findByJeloId").setParameter("jeloId", id).getSingleResult();
       j.getRestoranCollection().remove(r);
       edit(id, j);    
    }
    
    @GET
    @Path("/find/{naziv}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Jelo> findByName(@PathParam("naziv")String naziv){
    
    List<Jelo> lista = em.createQuery("select c from Jelo c where UPPER(c.naziv) LIKE :naziv").
                         setParameter("naziv", "%" + naziv + "%").getResultList();
    
    return lista;
    }
    
}
