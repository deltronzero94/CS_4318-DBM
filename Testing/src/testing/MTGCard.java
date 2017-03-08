package testing;

public class MTGCard
{
    //Private Declared Variables
    //private int CardID;
    private String CardName;
    private int MultiverseID;

    //Default Constructor
    public MTGCard()
    {
        //CardID = 0;
        CardName = "Test";
        MultiverseID = 123456789;
    }

    //COnstructor w/ 3 parameters
    public MTGCard( String CardName, int MultiverseID)
    {
        //this.CardID = CardID;
        this.CardName = CardName;
        this.MultiverseID = MultiverseID;
    }

    public String getCardName()
    {   return CardName;    }

    public int MultiverseID()
    {   return MultiverseID;    }


}