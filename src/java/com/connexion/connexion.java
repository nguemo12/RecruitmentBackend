
package com.connexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class connexion {
    private static Connection connect;
    private String url="jdbc:postgresql://localhost:5432/gojob_db";
    private String user="postgres";
    private String pswd="Jo1Vm54ves";
    private connexion(){
        try{
            Class.forName("org.postgresql.Driver");
        } catch(Exception e){
            System.out.println("error on driver:" + e.getMessage());
        }
        try{
            connect=DriverManager.getConnection(url,user,pswd);
        }catch(Exception e){
         System.out.println("Error on Connection:" + e.getMessage());
        }
}
public static Connection seconnecter(){
    if(connect==null){
        connexion connexion = new connexion();
    }
    return connect;
}
   
}
