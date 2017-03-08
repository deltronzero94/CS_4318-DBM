package json;

import java.util.ArrayList;
import java.util.List;

public class MTGCardList
{
    //Private Declared Variables
    protected String[] name;
    protected List<MTGCard> card;

    public MTGCardList()
    {}

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public List<MTGCard> getCard() {
        return card;
    }

    public void setCard(List<MTGCard> card) {
        this.card = card;
    }

   

}