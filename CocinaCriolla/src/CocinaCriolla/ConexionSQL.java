/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package CocinaCriolla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author aldaiR
 */
public class ConexionSQL {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        
        //jar sql server driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL= "jdbc:sqlserver://ALDAIR\\MSSQLSERVER2:1433;databaseName=SelfServiceDB;user=usuarioSQL;password=321;";
        Connection con=DriverManager.getConnection(connectionURL);
        System.out.println("Conectado a SQL SERVER");
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery ("SELECT  * FROM Producto");
        
        while (rs.next()) { 
            int ID = rs.getInt(1);
            String Nombre = rs.getString(2);
            String Precio = rs.getString(4); // Cambiamos a getString para Precio
            System.out.println(ID + ": " + Nombre + " S/." + Precio);
        }
    }
}
