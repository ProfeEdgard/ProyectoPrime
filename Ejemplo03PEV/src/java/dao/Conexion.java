
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;



public class Conexion {
    Connection conexion; // variable tipo Connection para la conexion a base de datos
    String url = "jdbc:mysql://localhost:3306/"; // inicio de la cadena de conexion
    String bd = "sistema01";  // variable para el nombre de nuestra base de datos
    String driver = "com.mysql.jdbc.Driver"; // driver de jdbc para mysql
    String usuario = "root"; // usuario de la base de datos
    String password = ""; // password del usuario de la base de datos
    
    // este metodo permite conectar con la base de datos
    public void conectar() throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        conexion = DriverManager.getConnection(url+bd,usuario,password);
    }
    //este metodo permite desconectar la base de datos
    public void desconectar() throws SQLException{
        if(!conexion.isClosed()){
            conexion.close();
        }
    }
    //este metodo obtiene un statemet a partir de la conexion
    //el statement permite ejecutar sentencias en la base de datos
    public Statement obtenerStatement() throws SQLException{
        return conexion.createStatement();
    }
    //este metodo obteiene un preparedStatement con una sentencia pre configurada
    //para ejecutar una sentencia con parametros en la base de datos
    public PreparedStatement obtenerPS(String sentencia) throws SQLException{
        return conexion.prepareStatement(sentencia);
    }
            
    
}
