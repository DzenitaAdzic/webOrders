/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import JsonBodyReader.FirmeReader;
import JsonBodyReader.JeloReader;
import com.google.gson.Gson;
import fxmldata.DiplomskiRadFX;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import model.Dnevnaponuda;
import model.Firma;
import model.Jelo;
import model.JeloNaPonudi;
import model.Restoran;

/**
 * FXML Controller class
 *
 * @author dzenita
 */
public class RestoranDnevnaPonudaController  {
    
    private static Restoran restoran;
    @FXML private TableView<Jelo> tableViewMeni, tableViewDnevnaPonuda;
    @FXML private TableColumn<Jelo,String> cijenaColumn;
    @FXML Button btnDodajNaPonudu, btnPosaljiDP, btnPosalji, btnIzbrisi;
    @FXML private TableView<Firma> tableViewFirme;
    private  static List<JeloNaPonudi> jeloNaPonudi = new ArrayList<JeloNaPonudi>();
  
    public void initData(Restoran restoran){
        this.restoran = restoran;
        cijenaColumn.setCellValueFactory(new PropertyValueFactory<Jelo,String>("cijena"));
        tableViewDnevnaPonuda.setEditable(true);
        cijenaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        cijenaColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Jelo, String>>(){
            @Override
            public void handle(TableColumn.CellEditEvent<Jelo, String> event) {
                
                Jelo j = tableViewDnevnaPonuda.getSelectionModel().getSelectedItem();
                j.setCijena(event.getNewValue().toString());
            }
        });
        
        fillMeni();
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
    private void btnDodajNaPonuduHandler(){  
        if(tableViewMeni.getSelectionModel().getSelectedItem() != null){
            Jelo jelo = tableViewMeni.getSelectionModel().getSelectedItem();
            ObservableList<Jelo> data = tableViewDnevnaPonuda.getItems();

            if(!data.contains(jelo))
                data.add(jelo);  
        }
    }
    
    @FXML 
    void btnPosaljiDnevnuPonudu() throws InterruptedException, IOException{
        
        if(!tableViewDnevnaPonuda.getItems().isEmpty()){
            
            List<Jelo> lista = tableViewDnevnaPonuda.getItems();
            Boolean empty = false;
            for(Jelo j : lista) {
                if(j.getCijena().isEmpty()) {
                    empty = true;  
                }
                JeloNaPonudi jelo = new JeloNaPonudi();
                jelo.setCijena(j.getCijena());
                jelo.setJeloId(Integer.toString(j.getJeloId()));
                jelo.setKolicina(Integer.toString(j.getKolicina()));
                jeloNaPonudi.add(jelo);
            }
            
            if(empty){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Greska");
                alert.setHeaderText(null);
                alert.setContentText("Niste unijeli cijenu za sva jela na dnevnoj ponudi");
                alert.showAndWait(); 
            }
            else{
                DiplomskiRadFX.posaljiFirmiDnevnuPonudu(); 
            }
        }
        else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Niste kreirali dnevnu ponudu!");
            alert.showAndWait();
        } 
    }
    
    public void initPosaljiFirmiDnevnuPonudu(){
        tableViewFirme.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        WebTarget clientTarget;
        ObservableList<Firma> data = tableViewFirme.getItems();
        data.clear();
        Client client = ClientBuilder.newClient();
        client.register(FirmeReader.class);
        
        clientTarget = client.target("http://localhost:8080/WebOrders/webresources/model.firma");
        
        GenericType<List<Firma>> listc = new GenericType<List<Firma>>() {};
        List<Firma> lista = clientTarget.request("application/json").get(listc);

        lista.forEach((f) -> {
            data.add(f);
        });      
    }
    
    @FXML
    private void btnPosaljiAction(){
        boolean greska = false;
        Client client = ClientBuilder.newClient();
        List<Firma> firma = tableViewFirme.getSelectionModel().getSelectedItems();
       
        for(Firma f : firma){
            Dnevnaponuda dp = new Dnevnaponuda();
            dp.setRestoranId(new Restoran(restoran.getRestoranId()));
            dp.setFirmaId(f);
            LocalDate now = LocalDate.now();
            dp.setDatum(new String(now.getYear()+"-"+ now.getMonthValue()+"-0"+now.getDayOfMonth()+"T00:00:00"));
            
            try {
                client.target("http://localhost:8080/WebOrders/webresources/model.dnevnaponuda")
                        .request().post(Entity.json(new Gson().toJson(dp)));

                Integer dnevnaPonudaId = client.target("http://localhost:8080/WebOrders/webresources/model.dnevnaponuda/restoranId/" + restoran.getRestoranId()+ "/firmaId/"+f.getFirmaId())
                    .request().get(Integer.class);

                for(JeloNaPonudi j : jeloNaPonudi) {
                    String jelo = new String("{  \"cijena\":"+ j.getCijena()+", \"jeloNaPonudiPK\": { \"dnevnaPonudaId\":" + dnevnaPonudaId +", \"jeloId\": "+j.getJeloId()+" } }");
                    System.out.println(jelo);
                    client.target("http://localhost:8080/WebOrders/webresources/model.jelonaponudi")
                        .request().post(Entity.json(jelo));
                }
                
                jeloNaPonudi.clear();
            }
            catch(RuntimeException e){
                greska = true;
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Greska");
                alert.setHeaderText(null);
                alert.setContentText("Greska prilikom slanja dnevne ponude");
                alert.showAndWait();
            } 
        }
        if(!greska){  
             Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("Potvrda");
             alert.setHeaderText(null);
             alert.setContentText("Uspjesno ste poslali dnevne ponude");
             alert.showAndWait();
        }
    }
    
    @FXML 
    private void btnIzbrisiAction(){
        if(tableViewDnevnaPonuda.getSelectionModel().getSelectedItem() != null) {
            Jelo j = tableViewDnevnaPonuda.getSelectionModel().getSelectedItem();
            tableViewDnevnaPonuda.getItems().remove(j);
        }
    }
}
