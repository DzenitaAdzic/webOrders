/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import JsonBodyReader.JeloReader;
import com.google.gson.Gson;
import fxmldata.DiplomskiRadFX;
import java.io.IOException;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import model.Jelo;
import model.Restoran;

/**
 * FXML Controller class
 *
 * @author dzenita
 */
public class RestoranMeniController {
    
    private Restoran restoran;
    
    @FXML private Button btnDodajUbazu, btnDodajNaMeni, btnIzbrisi, btndodajJelo, btnSearch;
    @FXML private TableView<Jelo> tableViewMeni, tableViewJela;
    @FXML private TextField txtNazivJela, txtJedinicaJela, txtKolicinaJela, txtSearch;
    @FXML private Label lblDodajJeloGreska;
 
    public void initData(Restoran restoran){
         
        this.restoran = restoran; 
        fillJela("http://localhost:8080/WebOrders/webresources/model.jelo");
        fillMeni();
    }
    
    @FXML
    private void btnDodajNaMeniHandler(){
        if(tableViewJela.getSelectionModel().getSelectedItem() != null){
            Jelo jelo = tableViewJela.getSelectionModel().getSelectedItem();
            Client client = ClientBuilder.newClient();
            client.target("http://localhost:8080/WebOrders/webresources/model.jelo/" + restoran.getRestoranId()+ "/meni")
                .request(MediaType.APPLICATION_JSON).put(Entity.json(new Gson().toJson(jelo)));

            ObservableList<Jelo> data = tableViewMeni.getItems();
            if(!data.contains(jelo))
                    data.add(jelo);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Niste izabrali jelo iz baze za dodavnje na jelovnik");
            alert.showAndWait();
       }
    }
    
    @FXML
    private void btnIDeleteFromMeniHandler(){
        if(tableViewMeni.getSelectionModel().getSelectedItem() != null){
            Jelo jelo = tableViewMeni.getSelectionModel().getSelectedItem();
            ObservableList<Jelo> data = tableViewMeni.getItems();
            data.remove(jelo);

            Client client = ClientBuilder.newClient();
            client.target("http://localhost:8080/WebOrders/webresources/model.jelo/" + jelo.getJeloId()+"/restoran/" + restoran.getRestoranId())
                    .request(MediaType.APPLICATION_JSON).put(Entity.json(new Gson().toJson(restoran)));
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Niste izabrali jelo sa jelovnika za brisanje");
            alert.showAndWait();
        }
    }
    
    private void fillJela(String url) {    
        WebTarget clientTarget;
        ObservableList<Jelo> data = tableViewJela.getItems();
        data.clear();
        Client client = ClientBuilder.newClient();
        client.register(JeloReader.class);
        
        clientTarget = client.target(url);
        
        GenericType<List<Jelo>> listc = new GenericType<List<Jelo>>() {};
        List<Jelo> meni = clientTarget.request("application/json").get(listc);

        meni.forEach((j) -> {
            data.add(j);
        });
    }
    
    private void fillMeni(){    
        WebTarget clientTarget;
        ObservableList<Jelo> data = tableViewMeni.getItems();
        data.clear();
        Client client = ClientBuilder.newClient();
        client.register(JeloReader.class);
        
        clientTarget = client.target("http://localhost:8080/WebOrders/webresources/model.restoran/" + restoran.getRestoranId()+ "/meni");
        
        GenericType<List<Jelo>> listc = new GenericType<List<Jelo>>() {};
        restoran.jeloCollection = clientTarget.request("application/json").get(listc);

        restoran.jeloCollection.forEach((j) -> {
            data.add(j);
        });
    }
     
    @FXML
    private void dodajUbazu() throws IOException {
       DiplomskiRadFX.addJelo();
    }
    
    @FXML 
    private void dodajJeloUbazu(){
        if( !txtNazivJela.getText().isEmpty() && !txtKolicinaJela.getText().isEmpty() && !txtJedinicaJela.getText().isEmpty()) {

            Jelo jelo = new Jelo();
            jelo.setNaziv(txtNazivJela.getText());
            jelo.setKolicina(Integer.parseInt(txtKolicinaJela.getText()));
            jelo.setJedinica(txtJedinicaJela.getText());

            try {
                Client client = ClientBuilder.newClient();
                client.target("http://localhost:8080/WebOrders/webresources/model.jelo/")
                        .request().post(Entity.json(new Gson().toJson(jelo)));
            }
            catch(RuntimeException r){
                System.out.println("greska");
            }
            txtNazivJela.setText("");
            txtKolicinaJela.setText("");
            txtJedinicaJela.setText("");
            } 

        else 
            lblDodajJeloGreska.setText("Popunite sva polja!");
    }
    
    @FXML
    void search(){
        fillJela("http://localhost:8080/WebOrders/webresources/model.jelo/find/"+txtSearch.getText());
    }
}
