package javamongoconection;

/**
 *
 * @author German Vargas
 * 
 */
public class JavaMongoConection {

    public static void main(String[] args) {
        
        Conection conn = new Conection();
        conn.getAll();
        System.out.println("Nuevo registro");
        //conn.insert("Turista Mundial");
        //conn.insert("Basta");
        //conn.insert("Ajedrez");
        //conn.insert("Jenga");
        //conn.update("Basta", "El nuevo Basta");
        conn.delete("Uno");
        conn.getAll();
        
    }
    
}
