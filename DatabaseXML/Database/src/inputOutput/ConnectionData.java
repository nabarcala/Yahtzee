/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputOutput;

/**
 *
 * @author natacha
 */
public class ConnectionData 
{
    //Member variables
    private String type;
    private String url;
    private String ipaddress;
    private String port;
    private String database;
    private String login;
    private String password;

    //Getters/setters for member variables

    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public String getUrl()
    {
        return url;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }
    public String getIpaddress()
    {
        return ipaddress;
    }
    public void setIpaddress(String ipaddress)
    {
        this.ipaddress = ipaddress;
    }
    public String getPort()
    {
        return port;
    }
    public void setPort(String port)
    {
        this.port = port;
    }
    public String getDatabase()
    {
        return database;
    }
    public void setDatabase(String database)
    {
        this.database = database;
    }
    public String getLogin()
    {
        return login;
    }
    public void setLogin(String login)
    {
        this.login = login;
    }
    public String getPassword() 
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    //Method toString() should concatenate member variables:
    //url, ipaddress, port, and database
    @Override
    public String toString()
    {
        //With format "jdbc:postgresql :// localhost : 5432 / dvdrental"
        return url + "://" + ipaddress + ":" + port + "/" + database;
        //url = jdbc:postgresql
        //ipadress = localhost
        //port = 5432  
        //database = dvdrental
    }
}
