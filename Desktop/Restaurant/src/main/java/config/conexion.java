/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

/**
 *
 * @author SuperAdmin
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
    Connection con;
    public conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/restaurante", "root", "");
            
        }catch(Exception e){
            System.err.println("No se pudo establecer conexion a la BD. Error: "+e);
        }
    }
    public Connection getConnection(){
        return con;
    }
}
