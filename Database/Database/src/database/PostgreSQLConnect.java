/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Natacha
 */
public class PostgreSQLConnect 
{
    public void makeConnection()
    {
        //Declare variable connect of type class Connection, initialize it to null
        Connection connect = null;
        
        //Write a try/catch block:
        try
        {
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dvdrental", "postgres", "cop3330");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            //Output to the user that the database connection was not successful
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0); 
        } 
        
        //After the catch, inform the user the connection to the database was successful!
        System.out.println("Opened database successfully"); 

    }
}
