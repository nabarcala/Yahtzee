/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Natacha
 */
public class Database {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //Instantiate and instance of class PostgreSQLConnect
        PostgreSQLConnect pgConnect = new PostgreSQLConnect();
        
        //Call method makeConnection() using the reference variable created above
        pgConnect.makeConnection(); 
    }
    
}
