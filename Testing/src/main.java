// Name: Carlos A. Rios
// Date: Mar 8, 2017
// Purpose: The purpose of this program is to learn how to look up data and pull that data
//          from the MTG JSON file. Also, to add this information into MYSQL Database.
//
// Notes: To run this program through command lines, use the following lines
//          Compile:
//              javac -cp gson.jar:/home/reticent/netbeans-8.2/ide/modules/ext/mysql-connector-java-5.1.23-bin.jar: -d ./ main.java
//          Running:
//              java -cp gson.jar:/home/reticent/netbeans-8.2/ide/modules/ext/mysql-connector-java-5.1.23-bin.jar: testing/java
//      *ASSUMING THAT YOU ARE IN FOLDER THAT MAIN.JAVA IS IN (which is .../Testing/src)
//      *Replace .jar paths with wherever .jar file is found on computer & the dir for the JSON file
//      * .jar files include the Google GSON.jar file & the mysql connector .jar file
//


package testing;

import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;  
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        
        //Declared Variables
        ArrayList<String> cardNames = new ArrayList<String>();  //Holds name of all cards
        ArrayList<Integer> cardID = new ArrayList<Integer>();   //Holds multiverseid of all card
        
        //Reading from JSON
        try
        {            
            //Declared Variables
            ArrayList <String> ls = new ArrayList<String>();    //Holds code name for all sets
            Set s;  //Temporarily holds the JObject as a set to substring the code name for each set
            Gson gson = new Gson();

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
        }
        catch (Exception e)
        {
            System.out.println("Error with JSON!");
        }

        //Storing Card information into the Database
        try
        {
            Connection connect = null;
            Statement statement = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            connect = DriverManager.getConnection("jdbc:mysql://localhost/mtg_testing?" + "user=root&password=q1w2e3r4");

            statement = connect.createStatement();

            //System.out.println(cardNames.get(11558) + ":" + cardID.get(11558));


            for (int x = 0; x < cardNames.size(); x++)
            {
                preparedStatement = connect.prepareStatement("insert into mtg_testing.Cards values (default, ?, ?)");

                preparedStatement.setString(1,cardNames.get(x));
                preparedStatement.setInt(2,cardID.get(x));
                preparedStatement.executeUpdate();
            }
        }
        catch (Exception e)
        {
            System.out.println("Error with Database!");
        }
        
    }
    
}
