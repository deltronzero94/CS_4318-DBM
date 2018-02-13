package mtg_dbm;
//derek started this file hello hi
public class Credentials 
{
    private final String username;
    private final String password;
    
    public Credentials(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public String getPassword()
    {
        return this.password;
    }
}
