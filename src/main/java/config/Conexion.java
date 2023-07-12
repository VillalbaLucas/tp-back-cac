package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB = "conferencia_bsas";
    private final String URL = "jdbc:mysql://localhost:3306/";
    private final String USER = "root";
    private final String PASS = "root";
    
    public Connection getConnection(){
        Connection conexion = null;
        
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL+DB, USER, PASS);
        }catch(ClassNotFoundException | SQLException e){
            System.err.print(e.toString());
        }
        return conexion;
    } 
    
}
