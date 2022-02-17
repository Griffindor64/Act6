package javamongoconection;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author German Vargas
 */
public class Conection {
    
    DB baseDatos;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject();
    
    public Conection(){
        try {
            Mongo mongo = new Mongo("localhost", 27017);
            baseDatos = mongo.getDB("JuegosMesa");
            coleccion = baseDatos.getCollection("JuegosMesa");
            System.out.println("Conexion establecida");
        } catch (UnknownHostException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public boolean insert(String juego){
        document.put("Nombre",juego);
        coleccion.insert(document);
        return true;
    }
    
    public void getAll(){
        DBCursor cursor = coleccion.find();
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }
    
    public boolean update(String valorViejo, String valorNuevo){
        document.put("Nombre", valorViejo);
        BasicDBObject documentoNuevo = new BasicDBObject();
        documentoNuevo.put("Nombre",valorNuevo);
        coleccion.findAndModify(document, documentoNuevo);
        return true;
    }
    
    public boolean delete(String valor){
        document.put("Nombre", valor);
        coleccion.remove(document);
        return true;
    }
}

