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
            BufferedReader br = new BufferedReader(
                new FileReader("/home/reticent/Downloads/AllSets-x.json"));
            
            
            //**********************Testing************************************
            // ---------------------------------------------------------------
            // Figured out how to search through specific set and find specific
            // information on those cards.
            //*****************************************************************
            BufferedReader t = new BufferedReader(
               new FileReader("/home/reticent/Downloads/AllSets-x.json"));
            
            JsonParser parser = new JsonParser();
//            JsonObject rootObj = parser.parse(t).getAsJsonObject();
//            
//            //Grabs Set
//            JsonObject details = rootObj.getAsJsonObject("LEA");
//           
//            //Gets cards in specific set
//            JsonArray card = details.getAsJsonArray("cards");
//            JsonElement c = card.get(0);
//           
//            //Gets information of card
//            System.out.println(c.getAsJsonObject().get("multiverseid"));
//            System.out.println(card.get(0).getAsJsonObject().get("name"));
            
            //****************************************************************
            // TODO: Substring each codeName into an array of strings and use
            //       to search for Sets and Cards.
            //****************************************************************

            
            JsonObject test = parser.parse(br).getAsJsonObject();

            Set s = test.entrySet();

            for (Object o : s)
            {   
                String q =o.toString();
                
                System.out.println(q.substring(0,60));
            }
            
            //*****************************************************************
            
            
            //JsonElement rootNode = parser.parse(t);
            
//            if (rootNode.isJsonObject())
//            {
//                JsonObject details = rootNode.getAsJsonObject();
//                
//                String temp = details.getAsString();
//                JsonElement nameNode = details.get("LEA");
//                System.out.println("NameNode: " + temp);
//            }
            
            //*********************END OF TESTING*******************************
            
            
            //System.out.println("\nName: " + rootNode); 
            
            //Object list = gson.fromJson(br, Object.class);
            
            //System.out.println("Name of List: "+ list);
            
            //String jsonOutput = gson.toJson(list);
            //System.out.println("Name of List: "+ jsonOutput);
            
        }
        catch (Exception e)
        {
            System.out.println("Error!");
        }
        
    }
    
}