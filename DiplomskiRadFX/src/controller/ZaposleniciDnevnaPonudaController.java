/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import JsonBodyReader.JeloNaPonudiReader;
import JsonBodyReader.RestoranRead;
import com.google.gson.Gson;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import model.JeloNaPonudi;
import model.Korisnik;
import model.Narudzba;
import model.Restoran;
import model.Stavka;
import model.StavkaPK;

/**
 * FXML Controller class
 *
 * @author dzenita
 */
public class ZaposleniciDnevnaPonudaController  {
    
    private static Korisnik zaposlenik;
    private static int dnevnaPonuda;
    private static Restoran restoran;
    private String url = "http://localhost:8080/WebOrders/webresources/";
    
    @FXML private Label lblNazivRestorana;
    @FXML private Button btnIzbrisi, btnDodaj, btnPosaljiNarudzbu;
    @FXML private TableView<JeloNaPonudi> tableViewMeni;
    @FXML private TableView<JeloNaPonudi> tableViewNarudzba;
    @FXML private TableColumn<JeloNaPonudi,String> kolicinaColumn, posebniZahtjevColumn, cijenaColumn;
    
    private int vrijemeZaNarudzbu = 9;
    
    public void initData(Korisnik zaposlenik){
        this.zaposlenik = zaposlenik;
        LocalTime time = LocalTime.now();
        lblNazivRestorana.setText("Glasanje nije zavrseno! ");
        
        if(time.getHour()>= vrijemeZaNarudzbu ){
            Client client = ClientBuilder.newClient();
            Integer dnevnaPonudaId = 0;
            boolean greska = false;
            try{
                dnevnaPonudaId = client.target(url + "model.glasanje/" 
                        + zaposlenik.getFirma().getFirmaId()+"/dnevnePonude").request().get(Integer.class);
                dnevnaPonuda = dnevnaPonudaId;
            }
            catch(RuntimeException e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Greska");
                alert.setHeaderText(null);
                alert.setContentText("Zao nam je, niste glasali ni za jednu ponudu ");
                alert.showAndWait(); 
                greska = true;
            }
            if(!greska){
                client.register(RestoranRead.class);
                Restoran r = client.target(url + "model.dnevnaponuda/restoranId/"+dnevnaPonudaId)
                        .request(MediaType.APPLICATION_JSON).get(Restoran.class);
                restoran = r;
                lblNazivRestorana.setText("Danasnja narudzba je iz restorana: "+ restoran.getNaziv());
                fillMeni(dnevnaPonudaId);
            }

            tableViewNarudzba.setEditable(true);
            kolicinaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
            posebniZahtjevColumn.setCellFactory(TextFieldTableCell.forTableColumn());

            kolicinaColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<JeloNaPonudi, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<JeloNaPonudi, String> event) {
                    JeloNaPonudi jelo = tableViewNarudzba.getSelectionModel().getSelectedItem();
                    jelo.setKolicina(event.getNewValue());

                    float cijena = Float.parseFloat(jelo.getKolicina()) * Float.parseFloat(jelo.getCijena());
                    tableViewNarudzba.getSelectionModel().getSelectedItem().setCijena(Float.toString(cijena));
                    tableViewNarudzba.refresh();
               }
            });

            posebniZahtjevColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<JeloNaPonudi, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<JeloNaPonudi, String> event) {
                    JeloNaPonudi jelo = tableViewNarudzba.getSelectionModel().getSelectedItem();
                    jelo.setDodatniZahtjev(event.getNewValue().toString());
               }
            });
        }
    }
    
    private void fillMeni(Integer dnevnaPonudaId){
        WebTarget clientTarget;
        Client client = ClientBuilder.newClient();
        client.register(JeloNaPonudiReader.class);
        
        clientTarget = client.target(url + "model.dnevnaponuda/"+ dnevnaPonudaId + "/jelaNaPonudi");
        
        GenericType<List<JeloNaPonudi>> listc = new GenericType<List<JeloNaPonudi>>() {};
        List<JeloNaPonudi> lista = clientTarget.request("application/json").get(listc);
        
        tableViewMeni.getItems().clear();
        lista.forEach((j) -> {
            if(!tableViewMeni.getItems().contains(j))
                tableViewMeni.getItems().add(j);
        });
    
    }
    
    @FXML
    public void dodajAction(){    
        if(tableViewMeni.getSelectionModel().getSelectedItem() != null){
            JeloNaPonudi jelo = tableViewMeni.getSelectionModel().getSelectedItem();
            ObservableList<JeloNaPonudi> data = tableViewNarudzba.getItems();
            if(!data.contains(jelo))
                    jelo.setKolicina("1");
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
    public void izbrisiAction(){
        if(tableViewNarudzba.getSelectionModel().getSelectedItem() != null){ 
            JeloNaPonudi jelo = tableViewNarudzba.getSelectionModel().getSelectedItem();
            tableViewNarudzba.getItems().remove(jelo);
        }
    }
    
    @FXML
    public void posaljiNarudzbuAction(){
        if(!tableViewNarudzba.getItems().isEmpty()){
            Client client = ClientBuilder.newClient();
            Collection<Stavka> stavke = new ArrayList<Stavka>();    
            Narudzba narudzba = new Narudzba();
            narudzba.setKorisnikId(zaposlenik);
            narudzba.setRestoranId(restoran);

            String json = new Gson().toJson(narudzba);
            boolean greska = false;
            try{
                Integer narudzbaId = client.target(url + "model.narudzba/korisnik/"+zaposlenik.getKorisnikId()+"/restoran/"+restoran.getRestoranId())
                        .request().get(Integer.class);
                System.out.println("narudzba try: " + narudzbaId);
                narudzba.setNarudzbaId(narudzbaId);
            }
            catch(RuntimeException e){
                client.target(url + "model.narudzba")
                        .request().post(Entity.json(new Gson().toJson(narudzba)));
                Integer narudzbaId = client.target(url + "model.narudzba/korisnik/"+zaposlenik.getKorisnikId()+"/restoran/"+restoran.getRestoranId())
                        .request().get(Integer.class);
                System.out.println("narudzba catch: " + narudzbaId);
                narudzba.setNarudzbaId(narudzbaId);
            }

            for(JeloNaPonudi j: tableViewNarudzba.getItems() ){
                StavkaPK stavkaPK = new StavkaPK(zaposlenik.getKorisnikId(),dnevnaPonuda, Integer.parseInt(j.getJeloId()) );
                Stavka stavka = new Stavka();
                stavka.setDodatniZahtjev(j.getDodatniZahtjev());
                stavka.setKolicina(Integer.parseInt(j.getKolicina()));
                stavka.setStavkaPK(stavkaPK);
                stavka.setNarudzbaId(narudzba);

                stavke.add(stavka);
                try{
                    client.target(url + "model.stavka")
                         .request().post(Entity.json(new Gson().toJson(stavka)));
                }
                catch(RuntimeException e){
                    greska = true;
                    System.out.println("Greska prilikom slanja narudzbe");
                }
            }

            if(!greska){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Narudzba");
                alert.setHeaderText(null);
                alert.setContentText("Uspjesno ste poslali narudzbu! ");
                alert.showAndWait(); 
            }
        }
    }  
}