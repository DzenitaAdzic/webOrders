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
import model.Firma;

/**
 *
 * @author dzenita
 */
@Provider
@Consumes({"application/json"})
public class FirmaReader implements MessageBodyReader<Firma>{

    @Override
    public boolean isReadable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
      return true;
    }

    @Override
    public Firma readFrom(Class<Firma> type, Type type1, Annotation[] antns, MediaType mt, MultivaluedMap<String, String> mm, InputStream in) throws IOException, WebApplicationException {
        
        if (mt.getType().equals("application") && mt.getSubtype().equals("json")) {             
            Firma firma = new Firma();
            JsonParser parser = Json.createParser(in);

            while (parser.hasNext()) {
                JsonParser.Event event = parser.next();
                switch (event) {
                    case START_OBJECT:
                        firma = new Firma();
                        break;
                    case END_OBJECT:
                        if(0 != firma.getFirmaId()) {                       
                         return firma;
                        }
                        break;
                    case KEY_NAME:
                         String key = parser.getString();
                         parser.next();
                         switch (key) {
                             case "firmaId":
                                 firma.setFirmaId(parser.getInt());
                                 break;
                            case "adresa":
                                firma.setAdresa(parser.getString());
                                break;
                            case "naziv":
                                firma.setNaziv(parser.getString());
                                break;
                            case "brojTelefona":
                                firma.setBrojTelefona(parser.getInt());
                                break; 
                            case "sifra":
                                firma.setSifra(parser.getString());
                                break;
                            case "brFax":
                                firma.setBrFax(parser.getString());
                                break;
                            case "email":
                                firma.setEmail(parser.getString());
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

    

