/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import inputOutput.ConnectionData;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;

/**
 *
 * @author natacha
 */
public final class PostgreSQLConnect 
{
    //Declare variable connect of type class Connection, initialize it to null
    private Connection connect = null;
    private ConnectionData data;
    
    public PostgreSQLConnect(ConnectionData cData) //throws SQLException, ClassNotFoundException
    {
        //makeConnection(data); 
        data = cData;
    }
    
    //public void PostgreSQLConnect(ConnectionData cData) throws SQLException, ClassNotFoundException
    public void makeConnection() //throws SQLException, ClassNotFoundException
    //public void makeConnection(ConnectionData cData) throws SQLException, ClassNotFoundException
    {
        System.out.println("try/block in PSQLC");
        //Write a try/catch block:
        try 
        {
            //Replace the hardcoded data "org.postgresql.Driver"
            //to method Class.forName() with method getType() from class ConnectionData
            Class.forName(data.getType()); 
 
            //Replace the hardcoded data "jdbc:postgresql://localhost:5432/dvdrental"
            //to method DriverManager.getConnection() with method toString() from class ConnectionData
            connect = DriverManager.getConnection(data.toString(), data.getLogin(), data.getPassword());
        }
        catch(Exception e)
        {
            //Output to the user that the database connection was not successful
            System.err.println("ERROR:");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace(); 
            System.exit(0); 
        }
 
        //After the catch, inform the user the connection to the database was successful!
        System.out.println("Opened database successfully");
    }

    public Connection makeConnect(ConnectionData data)
    { 
        //System.out.println("makeConnection()..."); 
        return connect;
    }
} 

