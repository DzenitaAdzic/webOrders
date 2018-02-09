/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonBodyReader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.stream.JsonParser;
import static javax.json.stream.JsonParser.Event.END_OBJECT;
import static javax.json.stream.JsonParser.Event.KEY_NAME;
import static javax.json.stream.JsonParser.Event.START_OBJECT;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import model.RNarudzba;

/**
 *
 * @author dzenita
 */
@Provider
@Consumes({"application/json"})
public class StavkeReader implements MessageBodyReader<List<RNarudzba>>{

    @Override
    public boolean isReadable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
      return true;
    }

    @Override
    public List<RNarudzba> readFrom(Class<List<RNarudzba>> type, Type type1, Annotation[] antns, MediaType mt, MultivaluedMap<String, String> mm, InputStream in) throws IOException, WebApplicationException {
        
         if (mt.getType().equals("application") && mt.getSubtype().equals("json")) {
                
            RNarudzba stavka = new RNarudzba();
            List<RNarudzba> stavke = new ArrayList();
            JsonParser parser = Json.createParser(in);
            
                while (parser.hasNext()) {
                    JsonParser.Event event = parser.next();
                    switch (event) {
                        case START_OBJECT:
                            stavka = new RNarudzba();
                            break;
                        case END_OBJECT:
                            stavke.add(stavka);
                            break;
                        case KEY_NAME:
                             String key = parser.getString();
                             parser.next();
                             switch (key) {
                                 case "cijena":
                                     stavka.setCijena(parser.getString());
                                     break;
                                case "jeloNaziv":
                                    stavka.setJeloNaziv(parser.getString());
                                    break;
                                case "naziv":
                                    stavka.setFirmaNaziv(parser.getString());
                                    break;
                                case "kolicina":
                                    stavka.setKolicina(parser.getString());
                                    break; 
                                case "username":
                                    stavka.setIme(parser.getString());
                                    break;
                                case "dodatniZahtjev":
                                    stavka.setDodatniZahtjev(parser.getString());
                                    break;
                                default:
                                    break;
                            }
                            break;
                    default:
                        break;
                    }
                }
              
            return stavke;         
            }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
