package mtg_dbm;
//derek was here
public class Authenticator
{
    private static Authenticator myInstance;
    private String loggedInUser;
    private boolean loggedIn;

    public Authenticator()
    {
        loggedIn = false;
    }

    public static Authenticator getInstance()
    {
        if (myInstance == null)
        {
            myInstance = new Authenticator();
        }
        return myInstance;
    }
    
    public boolean authenticate(String username, String password, Credentials cred)
    {
        if (username.equals(cred.getUsername()) && password.equals(cred.getPassword()))
        {
            loggedIn = true;
            loggedInUser = username;
        }
        else return false;

        return true;
    }

    public void logOut()
    {
        if (loggedIn)
        {
            loggedInUser = null;
            loggedIn = false;
        }
    }
    
    public boolean getLoggedIn()
    {
        return this.loggedIn;
    }

    public String getLoggedInUser()
    {
        return this.loggedInUser;
    }
}
