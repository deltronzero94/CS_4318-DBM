package testing;

import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;  
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reticent
 */
public class main {
    
    public static void main (String args[])
    {
        System.out.println("Hello World!");
        
        Gson gson = new Gson();
        
        try
        {            
            //Declared Variables
            ArrayList<String> cardNames = new ArrayList<String>();  //Holds name of all cards
            ArrayList<Integer> cardID = new ArrayList<Integer>();   //Holds multiverseid of all card
            ArrayList <String> ls = new ArrayList<String>();    //Holds code name for all sets
            Set s;  //Temporarily holds the JObject as a set to substring the code name for each set

            BufferedReader br = new BufferedReader(
                new FileReader("/home/reticent/Downloads/AllSets-x.json")); //BufferedReader to read from JSON file

            JsonParser parser = new JsonParser();
            JsonObject test = parser.parse(br).getAsJsonObject();
            s = test.entrySet();


            //Subtring each set code name to be able to pull from JSON File
            for (Object o : s)
            {   
                String str = o.toString();
                ls.add(str.substring(0,str.indexOf("=")));

                //System.out.println(str.substring(0,str.indexOf("=")));
            }

            //Pulling Card info from set
            for (int x = 0; x < ls.size(); x++) //1st For used to iterate through each set in ArrayList ls
            {
                JsonObject set = test.getAsJsonObject(ls.get(x));
                JsonArray card = set.getAsJsonArray("cards");
                int size_of_card = card.size();

                //System.out.println(size_of_card + " : Set(" + x + ")");

                //
                for (int i = 0; i < size_of_card; i++)  //2nd For used to iterate through each card in set
                {
                    JsonElement c = card.get(i);

                    if (c.getAsJsonObject().get("multiverseid") != null)    //If card has multiverseid, then add to ArrayList
                    {
                        cardNames.add(c.getAsJsonObject().get("name").getAsString());
                        cardID.add(c.getAsJsonObject().get("multiverseid").getAsInt());
                    }        
                }
            } 

            //Diplays all cards and their multiverseid
            for (int x = 0; x < cardNames.size(); x++)
            {
                System.out.println(cardNames.get(x) + ":" + cardID.get(x));
                
            }
            
        }
        catch (Exception e)
        {
            System.out.println("Error!");
        }
        
    }
    
}
