/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import JsonBodyReader.FirmaDnevnePonudeReader;
import JsonBodyReader.FirmaZaposleniciReader;
import JsonBodyReader.JeloNaPonudiReader;
import com.google.gson.Gson;
import fxmldata.DiplomskiRadFX;
import java.io.IOException;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import model.Firma;
import model.FirmaDnevnaPonuda;
import model.JeloNaPonudi;
import model.Korisnik;

/**
 * FXML Controller class
 *
 * @author dzenita
 */
public class FirmaController  {
    
    @FXML private Button btnDodajZaposlenika, btnDnevnePonude, btnZaposlenici, btnOdjaviSe, btnIzbrisiZaposlenika;
    @FXML private TextField txtSearch;
    @FXML private TableView<Korisnik> tableViewZaposlenici; 
    @FXML private TableView<FirmaDnevnaPonuda> tableViewDnevnePonude; 
    @FXML private ListView listViewdetalji;
    @FXML private Label lblNazivFirme, lblAdresaFirme;
    @FXML private ListView listView;
    
    @FXML private TextField txtIme;
    @FXML private TextField txtPrezime;
    @FXML private TextField txtUsername;
    @FXML private TextField txtPassword;
    
    private static Firma firma;
    private String url = "http://localhost:8080/WebOrders/webresources/";
    
  
    @FXML 
    private void fillTableZaposlenici(){
        WebTarget clientTarget;
        ObservableList<Korisnik> data = tableViewZaposlenici.getItems();
        data.clear();
        Client client = ClientBuilder.newClient();
        client.register(FirmaZaposleniciReader.class);
        
        clientTarget = client.target(url + "model.firma/"+firma.getFirmaId()+"/zaposlenici");
        
        GenericType<List<Korisnik>> listc = new GenericType<List<Korisnik>>() {};
        List<Korisnik> customers = clientTarget.request("application/json").get(listc);

        customers.forEach((c) -> { data.add(c); });
    }
        
    public void initData(Firma firma) {
        this.firma = firma;
        lblNazivFirme.setText(firma.getNaziv());
        lblAdresaFirme.setText(firma.getAdresa());
    } 
    
    public void dodajZaposlenika(){
        if(0 == txtIme.getText().length() || 0 == txtIme.getText().length()
                || 0 == txtUsername.getText().length()
                || 0 == txtPassword.getText().length())
            JOptionPane.showMessageDialog(null,"morate popuniti sva polja", "error", JOptionPane.ERROR_MESSAGE);
        else{
            boolean greska = false;
            Korisnik k = new Korisnik();
            k.setFirma(firma);
            k.setIme(txtIme.getText());
            k.setPrezime(txtPrezime.getText());
            k.setUsername(txtUsername.getText());
            k.setSifra(txtPassword.getText());
         
            try {
             Client client = ClientBuilder.newClient();
             client.target(url + "model.korisnik/")
                            .request().post(Entity.json(new Gson().toJson(k)));
            }
           catch(RuntimeException r){  
                greska = true;
                System.out.println("greska");
           }
           if(!greska){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Zaposlenici");
                alert.setHeaderText(null);
                alert.setContentText("Uspjesno ste dodali zaposlenika! ");
                alert.showAndWait(); 
           }
           
           ObservableList<Korisnik> data = tableViewZaposlenici.getItems();
           data.add(k);  
        }
    }
    
    public void enteredZaposlenici(MouseEvent event){
        btnZaposlenici.setStyle("-fx-background-color: #461306 ; -fx-text-fill: #e03a10");  
    }
    
    public void exitedZaposlenici(MouseEvent event){
        btnZaposlenici.setStyle("-fx-background-color: #461306");
    }
    
    public void enteredDnevnePonude(MouseEvent event){
        btnDnevnePonude.setStyle("-fx-background-color: #461306 ; -fx-text-fill: #e03a10");  
    }
    
    public void exitedDnevnePonude(MouseEvent event){
        btnDnevnePonude.setStyle("-fx-background-color: #461306");
    }
     
    public void odjaviSeExited(MouseEvent event){
        btnOdjaviSe.setStyle("-fx-background-color: #e03a10 ; -fx-text-fill: #c3bbbb");
    }
     
    public void odjaviSeEntered(MouseEvent event){
        btnOdjaviSe.setStyle("-fx-background-color :   #461306 ; -fx-text-fill: #c3bbbb");
    }
      
    public void clickedDnevnePonude() throws IOException {
        DiplomskiRadFX.showFirmaDnevnePonudeScene(firma);
    }
    
    public void clickedZaposlenici() throws IOException {       
        DiplomskiRadFX.showFirmaZaposleniciScene(firma);
    }
    
    @FXML
    public void btnOdjaviSeHandler() throws IOException {
        DiplomskiRadFX.showMainView();
    }
    
    public void initFirma(Firma firma){ 
        this.firma = firma;
        fillTableDnevnePonude();
    }
    
    public void initZaposlenici(Firma firma){ 
        this.firma = firma;
        fillTableZaposlenici();
    }
    
    @FXML 
    private void fillTableDnevnePonude(){
        WebTarget clientTarget;
        ObservableList<FirmaDnevnaPonuda> data = tableViewDnevnePonude.getItems();
        data.clear();
        Client client = ClientBuilder.newClient();
        client.register(FirmaDnevnePonudeReader.class);
        
        clientTarget = client.target(url + "model.firma/"+firma.getFirmaId()+"/dnevnePonude");
        
        GenericType<List<FirmaDnevnaPonuda>> listc = new GenericType<List<FirmaDnevnaPonuda>>() {};
        List<FirmaDnevnaPonuda> customers = clientTarget.request("application/json").get(listc);

        customers.forEach((c) -> {
            if(!data.contains(c))
                data.add(c); });
    }
    
    @FXML
    private void btnIzbrisiZaposlenikaHandler(){
        if(tableViewZaposlenici.getSelectionModel().getSelectedItem() != null){
            Korisnik korisnik = tableViewZaposlenici.getSelectionModel().getSelectedItem();

            ObservableList<Korisnik> data = tableViewZaposlenici.getItems();
            data.remove(korisnik);

            Client client = ClientBuilder.newClient();
            client.target(url + "model.korisnik/" + korisnik.getKorisnikId())
                    .request(MediaType.APPLICATION_JSON).delete(Korisnik.class);
        }
        else {
            JOptionPane.showMessageDialog(null,"Niste izabrali zaposlenika za brisanje", "error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @FXML
    private void tableViewDnevnePonudeHandler() {
        if(tableViewDnevnePonude.getSelectionModel().getSelectedItem() != null){
            WebTarget clientTarget;
            int id = tableViewDnevnePonude.getSelectionModel().getSelectedItem().getIdDnevnaPonuda();

            Client client = ClientBuilder.newClient();
            client.register(JeloNaPonudiReader.class);

            clientTarget = client.target(url + "model.dnevnaponuda/"+ id + "/jelaNaPonudi");

            GenericType<List<JeloNaPonudi>> listc = new GenericType<List<JeloNaPonudi>>() {};
            List<JeloNaPonudi> lista = clientTarget.request("application/json").get(listc);

            listView.getItems().clear();
            listView.getItems().add(new String("Naziv: \t\t Kolicina: \t\t Cijena: "));
            lista.forEach((j) -> {
                if(!listView.getItems().contains(j))
               listView.getItems().add(j);
            });
        }
    }
}