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
import model.Jelo;
import model.JeloNaPonudi;

/**
 *
 * @author dzenita
 */
@Provider
@Consumes({"application/json"})
public class JeloNaPonudiReader implements MessageBodyReader<List<JeloNaPonudi>> {

    @Override
    public boolean isReadable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
      return true;
    }

    @Override
    public List<JeloNaPonudi> readFrom(Class<List<JeloNaPonudi>> type, 
            Type type1, Annotation[] antns, MediaType mt, 
            MultivaluedMap<String, String> mm, InputStream in) 
            throws IOException, WebApplicationException {
        
        if (mt.getType().equals("application") && mt.getSubtype().equals("json")) {
            JeloNaPonudi jelo = new JeloNaPonudi();
            List<JeloNaPonudi> jela = new ArrayList();
            JsonParser parser = Json.createParser(in);

            while (parser.hasNext()) {
                JsonParser.Event event = parser.next();
                switch (event) {
                    case START_OBJECT:
                        jelo = new JeloNaPonudi();
                        break;
                    case END_OBJECT:
                        jela.add(jelo);  
                        break;
                    case KEY_NAME:
                         String key = parser.getString();
                         parser.next();
                         switch (key) {
                            case "cijena":
                                 jelo.setCijena(parser.getString());
                                 break;
                            case "naziv":
                                jelo.setJelo(parser.getString());
                                break;
                            case "kolicina":
                                jelo.setKolicina(parser.getString());
                                break;
                            case "popust":
                                jelo.setPopust(parser.getInt());
                                break;
                            case "jeloId":
                                jelo.setJeloId(parser.getString());
                                break;
                            case "jedinica":
                                jelo.setJedinica(parser.getString());
                                break;
                            case "dnevnaPonudaId":
                                jelo.setDnevnaPonudaId(parser.getString());
                                break;
                            default:
                            break;
                        }
                        break;
                default:
                    break;
                }
            }  
            return jela;            
        }
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
