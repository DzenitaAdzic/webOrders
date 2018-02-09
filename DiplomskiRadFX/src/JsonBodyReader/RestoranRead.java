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
import model.Restoran;

/**
 *
 * @author dzenita
 */
@Provider
@Consumes({"application/json"})
public class RestoranRead implements MessageBodyReader<Restoran>{

    @Override
    public boolean isReadable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
      return true;
    }

    @Override
    public Restoran readFrom(Class<Restoran> type, Type type1, Annotation[] antns, MediaType mt, MultivaluedMap<String, String> mm, InputStream in) throws IOException, WebApplicationException {
        
        if (mt.getType().equals("application") && mt.getSubtype().equals("json")) {
            Restoran restoran = new Restoran();
            JsonParser parser = Json.createParser(in);
            
            while (parser.hasNext()) {
                JsonParser.Event event = parser.next();
                switch (event) {
                    case START_OBJECT:
                        restoran = new Restoran();
                        break;
                    case END_OBJECT:
                        if(0 != restoran.getRestoranId()) {

                       System.out.println(restoran.toString());
                         return restoran;
                        }
                        break;
                    case KEY_NAME:
                         String key = parser.getString();
                         parser.next();
                         switch (key) {
                             case "restoranId":
                                 restoran.setRestoranId(parser.getInt());
                                 break;
                            case "adresa":
                                restoran.setAdresa(parser.getString());
                                break;
                            case "naziv":
                                restoran.setNaziv(parser.getString());
                                break;
                            case "brojTelefona":
                                restoran.setBrojTelefona(parser.getInt());
                                break; 
                            case "sifra":
                                restoran.setSifra(parser.getString());
                                break;
                            case "brFax":
                                restoran.setBrFax(parser.getString());
                                break;
                            case "email":
                                restoran.setEmail(parser.getString());
                                break;
                            default:
                            break;
                        }
                    break;
                    default:
                    break;
                }
            }      
        }
  
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
