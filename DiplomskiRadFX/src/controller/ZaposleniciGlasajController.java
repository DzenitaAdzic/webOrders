/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import JsonBodyReader.FirmaDnevnePonudeReader;
import JsonBodyReader.JeloNaPonudiReader;
import com.google.gson.Gson;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import model.FirmaDnevnaPonuda;
import model.Glasanje;
import model.JeloNaPonudi;
import model.Korisnik;

/**
 * FXML Controller class
 *
 * @author dzenita
 */
public class ZaposleniciGlasajController  {
    
    private static Korisnik zaposlenik;
    @FXML private Button btnIzbrisiSaListe, btnDodajNaListu, btnGlasaj;
    @FXML private TableView<FirmaDnevnaPonuda> tableViewDnevnePonude;
    @FXML private TableView<JeloNaPonudi> tableViewDetalji;
    @FXML private ListView<FirmaDnevnaPonuda> listViewGlasaj;
    
    private int vrijemeZaGlasanje = 12;
    private String url = "http://localhost:8080/WebOrders/webresources/";
    
    public void initData(Korisnik zaposlenik){
        this.zaposlenik = zaposlenik;
        System.out.println(zaposlenik.getFirma().getFirmaId());
        fillTableDnevnePonude();
    }
    
    private void fillTableDnevnePonude(){
        WebTarget clientTarget;
        ObservableList<FirmaDnevnaPonuda> data = tableViewDnevnePonude.getItems();
        data.clear();
        Client client = ClientBuilder.newClient();
        client.register(FirmaDnevnePonudeReader.class);
        try{
            clientTarget = client.target(url + "model.firma/"+zaposlenik.getFirma().getFirmaId()+"/dnevnePonude");

            GenericType<List<FirmaDnevnaPonuda>> listc = new GenericType<List<FirmaDnevnaPonuda>>() {};
            List<FirmaDnevnaPonuda> customers = clientTarget.request("application/json").get(listc);

            customers.forEach((c) -> {
                if(!data.contains(c))
                data.add(c); });
        }
        catch(RuntimeException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Zao nam je.\n Vasa firma nema pristiglih dnevni ponuda");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void tableViewDnevnePonudeHandler(){
        if(tableViewDnevnePonude.getSelectionModel().getSelectedItem() != null){
            WebTarget clientTarget;
            int id = tableViewDnevnePonude.getSelectionModel().getSelectedItem().getIdDnevnaPonuda();

            Client client = ClientBuilder.newClient();
            client.register(JeloNaPonudiReader.class);

            clientTarget = client.target(url + "model.dnevnaponuda/"+ id + "/jelaNaPonudi");

            GenericType<List<JeloNaPonudi>> listc = new GenericType<List<JeloNaPonudi>>() {};
            List<JeloNaPonudi> lista = clientTarget.request("application/json").get(listc);

            tableViewDetalji.getItems().clear();

            lista.forEach((j) -> {
                if(!tableViewDetalji.getItems().contains(j))
                    tableViewDetalji.getItems().add(j);
            });
        }
    }
    
    @FXML
    public void btnDodajHandler(){
        if(tableViewDnevnePonude.getSelectionModel().getSelectedItem() != null){
            FirmaDnevnaPonuda temp = tableViewDnevnePonude.getSelectionModel().getSelectedItem();
            if(!listViewGlasaj.getItems().contains(temp))
                listViewGlasaj.getItems().add(temp);
        }
    }
    
    @FXML
    public void btnIzbrisiHandler(){
        if(listViewGlasaj.getSelectionModel().getSelectedItem() != null){
            listViewGlasaj.getItems().remove(listViewGlasaj.getSelectionModel().getSelectedItem());
        }
    }
    
    @FXML
    public void btnGlasajHandler(){
        LocalTime time = LocalTime.now();
        if(time.getHour() < vrijemeZaGlasanje){
            List<Glasanje> glasaj = new ArrayList();

            for (FirmaDnevnaPonuda j : listViewGlasaj.getItems()) {
                Glasanje temmp = new Glasanje(zaposlenik.getKorisnikId(), j.getIdDnevnaPonuda());
                glasaj.add(temmp);
            }
            Client client = ClientBuilder.newClient();
            boolean greska = false;
            
            for(int i = 0; i< glasaj.size(); ++i ){
                glasaj.get(i).setBrojGlasova(i+1);
                Glasanje temp = glasaj.get(i);
                try{
                client.target(url + "model.glasanje")
                    .request().post(Entity.json(new Gson().toJson(temp)));
                }
                catch(RuntimeException e){
                    greska = true;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Greska");
                    alert.setHeaderText(null);
                    alert.setContentText("Zao nam je, vec ste glasali za neku dnevnu ponudu odabranih restorana ");
                    alert.showAndWait(); 
                }
            }
            if(!greska){
                greska = false;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Glasanje");
                alert.setHeaderText(null);
                alert.setContentText("Uspjesno ste glasali! ");
                alert.showAndWait(); 
            }
        }
        else{     
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Glasanje");
            alert.setHeaderText(null);
            alert.setContentText("Glasanje je zavrseno! ");
            alert.showAndWait(); 
        }
    }
}