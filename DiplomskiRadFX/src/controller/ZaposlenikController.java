/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fxmldata.DiplomskiRadFX;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.Korisnik;

/**
 * FXML Controller class
 *
 * @author dzenita
 */
public class ZaposlenikController {
    
    private static Korisnik zaposlenik;
    @FXML private Label lblImePrezime, lblUsername;
    @FXML private Button btnOdjaviSe, btnGlasaj, btnDnevnaPonuda;
    
    public void initData(Korisnik zaposlenik){
        this.zaposlenik = zaposlenik;
        lblImePrezime.setText(zaposlenik.getIme() + " " + zaposlenik.getPrezime());
        lblUsername.setText(zaposlenik.getUsername());
    }
    
    @FXML
    private void odjaviSeAction() throws IOException{
        DiplomskiRadFX.showMainView();
    }
    
    public void glasajMouseEntered(MouseEvent event){
        btnGlasaj.setStyle("-fx-background-color: #461306 ; -fx-text-fill: #e03a10");
    }
    
    public void glasajMouseExited(MouseEvent event){
        btnGlasaj.setStyle("-fx-background-color: #461306");
    }
    
    public void dnevnaPonudaEntered(MouseEvent event){
        btnDnevnaPonuda.setStyle("-fx-background-color: #461306 ; -fx-text-fill: #e03a10");
       
    }
    public void dnevnaPonudaExited(){
        btnDnevnaPonuda.setStyle("-fx-background-color: #461306");
    }
    
    public void odjaviSeExited(){
        btnOdjaviSe.setStyle("-fx-background-color: #461306");
    }
    public void odjaviSeEntered(){
        btnOdjaviSe.setStyle("-fx-background-color: #461306 ; -fx-text-fill: #e03a10");
    }
    
    public void dnevnaPonudaClicked() throws IOException{
        DiplomskiRadFX.showZaposleniciDnevnaPonudaScene(zaposlenik);
    }
    public void glasajClicked() throws IOException {
        DiplomskiRadFX.showZaposleniciGlasajScene(zaposlenik);
    }
}
