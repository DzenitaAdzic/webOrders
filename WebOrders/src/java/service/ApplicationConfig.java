/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author dzenita
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.DnevnaponudaFacadeREST.class);
        resources.add(service.FirmaFacadeREST.class);
        resources.add(service.GlasanjeFacadeREST.class);
        resources.add(service.JeloFacadeREST.class);
        resources.add(service.JeloNaPonudiFacadeREST.class);
        resources.add(service.KorisnikFacadeREST.class);
        resources.add(service.NarudzbaFacadeREST.class);
        resources.add(service.RestoranFacadeREST.class);
        resources.add(service.StavkaFacadeREST.class);
    }
    
}
