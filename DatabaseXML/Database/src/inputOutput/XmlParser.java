/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputOutput;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node; 
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author natacha
 */
public class XmlParser 
{
    //Member variables
    private ConnectionData connectionData; 
    private Document document;

    //Getter for member variable connectionData
    /**
     *
     * @return 
     */
//    public ConnectionData getConnectionData() 
//    {
//        return connectionData;
//    } 
    
    //Constructor
    public XmlParser(String xmlName) throws ParserConfigurationException
    {
        //Define one parameter of type String storing the name of XML file to parse
        //System.out.println("Going through XmlFile...");
        //Call method parseXmlFile() passing the parameter as an argument
        parseXmlFile(xmlName);
    } 

    //Method parseXmlFile() 
    private void parseXmlFile(String location) throws ParserConfigurationException
    {
        //Define one parameter of type String storing the name of the XML file to parse
        //System.out.println("Going through parseXmlFile...");
        
        //Create an instance of class DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        
        //Write a try/catch block:
        try 
        {
            //Using factory get an instance of document builder
            //Create an instance of class DocumentBuilder
            DocumentBuilder db = dbf.newDocumentBuilder();

            //Load and Parse the XML document document contains the complete XML as a Tree.
            //Instantiate member variable document to the parse
            document = db.parse(ClassLoader.getSystemResourceAsStream(location));
            //DocumentBuilder passing argument ClassLoader.getSystemResourceAsStream() 
            //passing the parameter for method parseXmlFile as an argument 
            
            //Iterating through the nodes and extracting the data.
            NodeList nodeList = document.getDocumentElement().getChildNodes();
            //Create an instance of class NodeList,
            //instantiate it with method getDocumentElement().getChildNodes()
            
            //Loop through the length of the NodeList instance
            for(int i = 0; i < nodeList.getLength(); i++) 
            {
                //Create an instance of class Node, instantiate it to method item()
                // of instance NodeList
                Node node = nodeList.item(i);

                //Get each element from XML element <driver>
                if(node instanceof Element)
                {
                    //Instantiate member variable connectionData 
                    //setting each of its member variables relative to the
                    // elements in the properties.xml file
                    
                    String type = node.getAttributes().getNamedItem("type").getNodeValue();
                    
                    //Create a new connection
                    ConnectionData connectionData = new ConnectionData();
                    //Set the connectionData type
                    connectionData.setType(type); 
                     
                    NodeList childNodes = node.getChildNodes();

                    for(int j = 0; j < childNodes.getLength(); j++) 
                    {
                        Node cNode = childNodes.item(j);  
 
                        //Identifying the child tag of employee encountered.
                        if (cNode instanceof Element) 
                        {
                            String content = cNode.getLastChild().getTextContent().trim();
                            
                            switch(cNode.getNodeName()) 
                            {
                                case "url":
                                    connectionData.setUrl(content);
                                    break;
                                case "ipaddress":
                                    connectionData.setIpaddress(content);
                                    break;
                                case "port":
                                    connectionData.setPort(content);
                                    break;
                                case "database":
                                    connectionData.setDatabase(content);
                                    break;
                                case "login":
                                    connectionData.setLogin(content);
                                    break;
                                case "password":
                                    connectionData.setPassword(content);
                                    break;
                            }
                        }
                    }             
                }
            } 
        }
        //Catch the exceptions
        catch(ParserConfigurationException pce) 
        {
            pce.printStackTrace();
        }
        catch(SAXException se) 
        {
            se.printStackTrace();
        }
        catch(IOException ioe) 
        {
            ioe.printStackTrace(); 
        }
        //After the catch, inform the user the connection to the database was successful!
        System.out.println("Opened database successfully");
    }
    //Getter for member variable connectionData
    /**
     *
     * @return 
     */
    public ConnectionData getConnectionData()
    {
        //System.out.println("GetConnectionData()...");
        return connectionData;
    }   
}
