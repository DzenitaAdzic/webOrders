/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fxmldata.DiplomskiRadFX;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Restoran;

/**
 * FXML Controller class
 *
 * @author dzenita
 */
public class RestoranController implements Initializable{
    
    @FXML private Pane imgMeni, imgDnevnaPonuda, imgNarudzba;
    @FXML private Label lblRestoranNaziv, lblRestoranAdresa;
    @FXML private Button btnPocetna, btnPocetna1, btnPocetna2, btnPocetna3, btnOdjaviSe;
       
    private static Restoran restoran;

    public void initData(Restoran restoran) {        
        this.restoran = restoran;
        lblRestoranNaziv.setText(restoran.getNaziv());
        lblRestoranAdresa.setText(restoran.getAdresa());
    }
    
    public void mauseEnteredMeni(MouseEvent event)
    {
     imgMeni.setStyle("-fx-background-color : #b8b098");
    }
    
    public void EnteredMeni(MouseEvent event)
    {
        btnPocetna1.setStyle("-fx-background-color: #461306 ; -fx-text-fill: #e03a10");  
    }
    
     public void mauseExitedMeni(MouseEvent event)
    {
     imgMeni.setStyle("-fx-background-color :  #fff1");
    }
     
    public void ExitedMeni(MouseEvent event)
    {
     btnPocetna1.setStyle("-fx-background-color: #461306");
    }
    
    public void mauseEnteredDnevnaPonuda(MouseEvent event)
    {
     imgDnevnaPonuda.setStyle("-fx-background-color : #b8b098");
    }
    
    public void EnteredDnevnaPonuda(MouseEvent event)
    {
      btnPocetna2.setStyle("-fx-background-color: #461306 ; -fx-text-fill: #e03a10");  
    }
    
     public void mauseExitedDnevnaPonuda(MouseEvent event)
    {
     imgDnevnaPonuda.setStyle("-fx-background-color :  #fff1");
    }
     
     public void ExitedDnevnaPonuda(MouseEvent event)
    {
      btnPocetna2.setStyle("-fx-background-color: #461306");
    }
    
    public void mauseEnteredNarudzba(MouseEvent event)
    {
     imgNarudzba.setStyle("-fx-background-color : #b8b098");
    }
    
     public void EnteredNarudzba(MouseEvent event)
    {
      btnPocetna3.setStyle("-fx-background-color: #461306 ; -fx-text-fill: #e03a10");  
    }
    
     public void mauseExitedNarudzba(MouseEvent event)
    {
     imgNarudzba.setStyle("-fx-background-color :  #fff1");
    }
     
     public void ExitedNarudzba(MouseEvent event)
    {
      btnPocetna3.setStyle("-fx-background-color: #461306");
    }
     
     public void mauseEnteredPocetna(MouseEvent event)
    {
     btnPocetna.setStyle("-fx-background-color: #461306 ; -fx-text-fill: #e03a10");
    }
     
    public void mauseExitedPocetna(MouseEvent event)
    {
     btnPocetna.setStyle("-fx-background-color :   #461306");
    }
    
     public void odjaviSeEntered(MouseEvent event)
    {
     btnOdjaviSe.setStyle("-fx-background-color: #e03a10 ; -fx-text-fill: #c3bbbb");  
    }
     
    public void odjaviSeExited(MouseEvent event)
    {
     btnOdjaviSe.setStyle("-fx-background-color :   #461306 ; -fx-text-fill: #c3bbbb");
    }
     
    public void mouseClickedMeni(MouseEvent event) throws IOException
    {
         DiplomskiRadFX.showRestaurantMeniScene(restoran);
    }
    
    public void ClickedMeni() throws IOException
    {
         DiplomskiRadFX.showRestaurantMeniScene(restoran);  
    }
    
    public void mouseClickedDnevnaPonuda(MouseEvent event) throws IOException
    {
        DiplomskiRadFX.showRestoranDnevnaPonudaScene(restoran);
    }
    
    public void ClickedDnevnaPonuda() throws IOException
    {
        DiplomskiRadFX.showRestoranDnevnaPonudaScene(restoran);
    }
    
    public void mouseClickedNarudzba(MouseEvent event) throws IOException
    {
        DiplomskiRadFX.showRestoranNarudzbaScene(restoran);
    }
    
     public void ClickedNarudzba() throws IOException
    {
        DiplomskiRadFX.showRestoranNarudzbaScene(restoran);
    }
    
    public void goPocetna(ActionEvent event) throws IOException
    {
        DiplomskiRadFX.showRestaurantScene(restoran);
    }
    @FXML
    public void btnOdjaviSeHandler() throws IOException
    {
        DiplomskiRadFX.showMainView();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
}
