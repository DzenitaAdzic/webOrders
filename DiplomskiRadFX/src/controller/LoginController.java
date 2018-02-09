/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import JsonBodyReader.FirmaReader;
import JsonBodyReader.KorisnikReader;
import JsonBodyReader.RestoranRead;
import fxmldata.DiplomskiRadFX;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import model.Firma;
import model.Korisnik;
import model.Restoran;

/**
 *
 * @author dzenita
 */
public class LoginController implements Initializable {
    ObservableList<String> loginChoice = FXCollections.observableArrayList("Restoran", "Firma", "Zaposlenik");
    private Restoran restoran;
    private Firma firma;
    private Korisnik zaposlenik = new Korisnik();
    private DiplomskiRadFX main;
    private String url = "http://localhost:8080/WebOrders/webresources/";
    
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private Button btnLogIn;
    @FXML private ComboBox cmb;
    @FXML private Label lblGreska;

    @FXML
    private void logInBtnHandler() throws IOException  {
        
        if("Restoran" == cmb.getValue()) {
            try {
                getRestoran();  
            }
            catch(RuntimeException ex) {
                lblGreska.setText("greska u bazi");
            }
            if(txtPassword.getText() == null ? restoran.getSifra() == null : txtPassword.getText().equals(restoran.getSifra()))
                DiplomskiRadFX.showRestaurantScene(restoran);
            else
                 lblGreska.setText("Pogresan naziv ili sifra");
        }
        if("Firma" == cmb.getValue()) {
            try {
                getFirma();  
            }
            catch(RuntimeException ex){
                lblGreska.setText("greska u bazi");
            }
            if(txtPassword.getText() == null ? firma.getSifra() == null : txtPassword.getText().equals(firma.getSifra()))
                DiplomskiRadFX.showFirmaScene(firma);
            else
                 lblGreska.setText("Pogresan naziv ili sifra");
        }
        if("Zaposlenik" == cmb.getValue()) {
            try {
                getZaposlenik();  
            }
            catch(RuntimeException ex){
                lblGreska.setText("greska u bazi");
            }
            if(txtPassword.getText() == null ? zaposlenik.getSifra() == null : txtPassword.getText().equals(zaposlenik.getSifra()))
                DiplomskiRadFX.showZaposlenikScene(zaposlenik);
            else
                 lblGreska.setText("Pogresan naziv ili sifra");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       cmb.setItems(loginChoice);
    }
    
    @FXML
    private void getRestoran() {
        WebTarget clientTarget;
        Client client = ClientBuilder.newClient();
        client.register(RestoranRead.class);
        clientTarget = client.target(url + "model.restoran/naziv/" + txtUsername.getText());
        
        restoran  = clientTarget.request(MediaType.APPLICATION_JSON).get(Restoran.class);
    }
    
    private void getFirma() {    
        WebTarget clientTarget;
        Client client = ClientBuilder.newClient();
        client.register(FirmaReader.class);
        clientTarget = client.target(url + "model.firma/naziv/" + txtUsername.getText());
        
        firma  = clientTarget.request(MediaType.APPLICATION_JSON).get(Firma.class);
    }
    
    private void getZaposlenik() {    
        WebTarget clientTarget;
        Client client = ClientBuilder.newClient();
        client.register(KorisnikReader.class);
        System.out.println(txtUsername.getText());
        clientTarget = client.target(url + "model.korisnik/naziv/" + txtUsername.getText());
        
        zaposlenik  = clientTarget.request(MediaType.APPLICATION_JSON).get(Korisnik.class);
    }
}