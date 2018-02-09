/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import JsonBodyReader.NarudzbaReader;
import JsonBodyReader.StavkeReader;
import fxmldata.DiplomskiRadFX;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import model.RNarudzba;
import model.Restoran;

/**
 * FXML Controller class
 *
 * @author dzenita
 */
public class RestoranNarudzbeController  {

    private static Restoran restoran;
    @FXML private TableView<RNarudzba> tableViewNarudzbe, tableViewZavrseneNarudzbe;
    @FXML private Button btnDodaj, btnPregledaj, btnIzbrisi;
    private static List<RNarudzba> zavrseneNarudzbe = new ArrayList();
    
    public void initData(Restoran restoran){
        this.restoran = restoran;
        fillNarudzbe();
    }
    
    private void fillNarudzbe(){
        WebTarget clientTarget;
        Client client = ClientBuilder.newClient();
        client.register(NarudzbaReader.class);
        clientTarget = client.target("http://localhost:8080/WebOrders/webresources/model.restoran/narudzbe/"+ restoran.getRestoranId());
        
        GenericType<List<Integer>> listc = new GenericType<List<Integer>>() {};
        List<Integer> meni = clientTarget.request("application/json").get(listc);

        Client client2 = ClientBuilder.newClient();
        GenericType<List<RNarudzba>> r = new GenericType<List<RNarudzba>>() {};
        client2.register(StavkeReader.class);
        meni.forEach((j) -> {
            List<RNarudzba> ko = client2.target("http://localhost:8080/WebOrders/webresources/model.stavka/stavke/"+j).request("application/json").get(r);
            for(RNarudzba narudzba : ko){
                narudzba.setNarudzbaId(Integer.toString(j));
                tableViewNarudzbe.getItems().add(narudzba);
            }
             }); 
    }
    
    @FXML
    public void btnDodajHandler(){
        if(tableViewNarudzbe.getSelectionModel().getSelectedItem() != null){
            RNarudzba e = tableViewNarudzbe.getSelectionModel().getSelectedItem();
            zavrseneNarudzbe.add(e);
            tableViewNarudzbe.getItems().remove(e);
        }
    }
    
    @FXML
    public void btnIzbrisiHandler(){
        Client client = ClientBuilder.newClient();
        for(RNarudzba r : zavrseneNarudzbe){
            System.out.println("izbrisi : "+r.getNarudzbaId());
            client.target("http://localhost:8080/WebOrders/webresources/model.narudzba/"+r.getNarudzbaId())
                    .request().delete();
        }
    }
    
    @FXML
    public void btnPregledajHandler() throws IOException{
        DiplomskiRadFX.pregledajZavrseneNarudzbe();
    }
    
    public void initZavrsenePonude(){
        for(RNarudzba r : zavrseneNarudzbe){
            tableViewZavrseneNarudzbe.getItems().add(r);
        }
    }
    
}
