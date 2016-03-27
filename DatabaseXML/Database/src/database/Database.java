/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
 
import inputOutput.ConnectionData;
import inputOutput.XmlParser;
import java.sql.SQLException;
import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author natacha
 */
public class Database 
{

    /** 
     * @param args the command line arguments  
     */
    public static void main(String[] args) throws ParserConfigurationException, SQLException, ClassNotFoundException
    {
        //Create an instance of class XmlParser,
        XmlParser xml = new XmlParser("inputOutput/properties.xml");
         
        //Declare a variable of class ConnectionData;
        ConnectionData data = xml.getConnectionData();
        //instantiate it by setting it equal to the return variable
        //from class XmlParser method getConnectionData()

        //Update creating an instance of class PostgreSQLConnect
        
        //Instantiate and instance of class PostgreSQLConnect
        PostgreSQLConnect connect = new PostgreSQLConnect(data);
        //by passing the variable of class ConnectionData as an argument to the constructor
    
        //Connection dbConnect = connect.makeConnect(dbConnect);
    }
    
}
