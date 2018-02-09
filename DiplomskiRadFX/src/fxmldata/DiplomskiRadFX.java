/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmldata;

import controller.FirmaController;
import controller.RestoranController;
import controller.RestoranDnevnaPonudaController;
import controller.RestoranMeniController;
import controller.RestoranNarudzbeController;
import controller.ZaposleniciDnevnaPonudaController;
import controller.ZaposleniciGlasajController;
import controller.ZaposlenikController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import model.Firma;
import model.Korisnik;
import model.Restoran;

/**
 *
 * @author dzenita
 */
public class DiplomskiRadFX extends Application {
    
    private static Stage primaryStage;
    private static BorderPane mainLayout, restaurantScene;
    private static BorderPane firmaScene, zaposlenikScene;
     
    @Override
    public void start(Stage stage) throws IOException {  
      this.primaryStage = stage;
      this.primaryStage.setTitle("Web narudzbe");
      
      showMainView();  
    }
    
    public static  void showMainView() throws IOException
    {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(DiplomskiRadFX.class.getResource("Login.fxml"));
    mainLayout = loader.load();
    Scene scene = new Scene(mainLayout);
    primaryStage.setScene(scene);
    primaryStage.show();
   
    }
   
    public static void showRestaurantScene(Restoran restoran) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DiplomskiRadFX.class.getResource("Restoran.fxml"));
        restaurantScene = loader.load();
        RestoranController controller = loader.getController();
        controller.initData(restoran);
        Scene scene = new Scene(restaurantScene);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
    
     public static void showFirmaScene(Firma firma) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DiplomskiRadFX.class.getResource("Firma.fxml"));
        firmaScene = loader.load();
        FirmaController controller = loader.getController();
        controller.initData(firma);
        Scene scene = new Scene(firmaScene);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
    
    public static void showZaposlenikScene(Korisnik zaposlenik) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DiplomskiRadFX.class.getResource("Zaposlenik.fxml"));
        zaposlenikScene = loader.load();
        ZaposlenikController controller = loader.getController();
        controller.initData(zaposlenik);
        Scene scene = new Scene(zaposlenikScene);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
    
    public static void showFirmaDnevnePonudeScene(Firma firma) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DiplomskiRadFX.class.getResource("FirmaDnevnePonude.fxml"));
        AnchorPane firmaZap = loader.load();
        FirmaController firmaZaposlenici = loader.getController();
        firmaZaposlenici.initFirma(firma);
        firmaScene.setCenter(firmaZap);
   
    }
    
    public static void showFirmaZaposleniciScene(Firma firma) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DiplomskiRadFX.class.getResource("FirmaZaposlenici.fxml"));
        AnchorPane firmaZap = loader.load();
        FirmaController firmaZaposlenici = loader.getController();
        firmaZaposlenici.initZaposlenici(firma);
        firmaScene.setCenter(firmaZap);
   
    } 
     
     public static void showRestaurantMeniScene(Restoran restoran) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DiplomskiRadFX.class.getResource("RestoranMeni.fxml"));
        BorderPane restoranMeni = loader.load();
        RestoranMeniController restoranmeni = loader.getController();
        restoranmeni.initData(restoran);
        restaurantScene.setCenter(restoranMeni);
   
    }
     
     public static void showRestoranDnevnaPonudaScene(Restoran restoran) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DiplomskiRadFX.class.getResource("RestoranDnevnaPonuda.fxml"));
        BorderPane restoranDnevnaPonuda = loader.load();
        RestoranDnevnaPonudaController  control= loader.getController();
        control.initData(restoran);
        restaurantScene.setCenter(restoranDnevnaPonuda);
   
    }
     
      public static void showRestoranNarudzbaScene(Restoran restoran) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DiplomskiRadFX.class.getResource("RestoranNarudzbe.fxml"));
        BorderPane restoranNarudzba = loader.load();
        RestoranNarudzbeController  control= loader.getController();
        control.initData(restoran);
        restaurantScene.setCenter(restoranNarudzba);
   
    }
      
    public static void showZaposleniciDnevnaPonudaScene(Korisnik zaposlenik) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DiplomskiRadFX.class.getResource("ZaposleniciDnevnaPonuda.fxml"));
        AnchorPane zaposlenici = loader.load();
        ZaposleniciDnevnaPonudaController  control= loader.getController();
        control.initData(zaposlenik);
        zaposlenikScene.setCenter(zaposlenici);
   
    }
    
    public static void showZaposleniciGlasajScene(Korisnik zaposlenik) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DiplomskiRadFX.class.getResource("ZaposleniciGlasaj.fxml"));
        AnchorPane zaposlenici = loader.load();
        ZaposleniciGlasajController  control= loader.getController();
        control.initData(zaposlenik);
        zaposlenikScene.setCenter(zaposlenici);
   
    }
    public static void addJelo() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DiplomskiRadFX.class.getResource("AddJelo.fxml"));
        AnchorPane addJelo = loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);
        Scene scene = new Scene(addJelo);
        stage.setScene(scene);
        stage.showAndWait();
        
    }
    
    public static void posaljiFirmiDnevnuPonudu() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DiplomskiRadFX.class.getResource("PosaljifirmiDP.fxml"));
        AnchorPane addJelo = loader.load();
        RestoranDnevnaPonudaController controler = loader.getController();
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);
        controler.initPosaljiFirmiDnevnuPonudu();
        
        Scene scene = new Scene(addJelo);
        stage.setScene(scene);
        stage.showAndWait();
        
    }
    
    public static void pregledajZavrseneNarudzbe() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DiplomskiRadFX.class.getResource("RestoranZavrseneNarudzbe.fxml"));
        BorderPane addJelo = loader.load();
        RestoranNarudzbeController controller = loader.getController();
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);
        controller.initZavrsenePonude();
        
        Scene scene = new Scene(addJelo);
        stage.setScene(scene);
        stage.showAndWait();
        
    }
    

   
    
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
