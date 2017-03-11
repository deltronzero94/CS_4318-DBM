package testdatabaseapp;

import java.io.*;
import java.sql.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Importer 
{
    private JSONParser parser = new JSONParser();
    private Connection connect = null;
    private PreparedStatement preparedStatement = null;

    public int loadSets() throws Exception
    {
        int status = 0;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdbmagic?" + "user=root&password=notmustard");
            System.out.println("Connection successful");
            
            preparedStatement = connect.prepareStatement("INSERT INTO Sets VALUES (?, ?, ?, ?)");
            
            JSONArray setArray = (JSONArray) JSONValue.parse(new FileReader("C:\\Users\\Resu Eman\\Desktop\\allsetsarray.json"));
            
            for (int i = 0; i < setArray.size(); i++)
            {
                JSONObject thisSet = (JSONObject) setArray.get(i);

                String name = (String) thisSet.get("name");
                System.out.println(name);
                preparedStatement.setString(1, name);

                String date = (String) thisSet.get("releaseDate");
                preparedStatement.setString(2, date);

                String code = (String) thisSet.get("code");
                preparedStatement.setString(3, code);

                String type = (String) thisSet.get("type");
                preparedStatement.setString(4, type);

                status = preparedStatement.executeUpdate();
            }
            return status;
        }   
        catch (Exception e)
        {
            throw e;
        } 
        finally
        {
            try
            {
                if (connect != null)
                {
                    connect.close();
                }
            }
            catch (Exception e)
            {
                
            }
        }
    }
    
    public int loadCards() throws Exception
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdbmagic?" + "user=root&password=notmustard");
            System.out.println("Connection successful");
            
            int status = 0;
            preparedStatement = connect.prepareStatement("INSERT INTO Cards VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            JSONArray setArray = (JSONArray) JSONValue.parse(new FileReader("C:\\Users\\Resu Eman\\Desktop\\allsetsarray.json"));
            JSONArray thisCardArray = null;
            JSONObject thisCard = null;
            JSONObject thisSet = null;
            for (int i = 0; i < setArray.size(); i++)
            {
                thisSet = (JSONObject) setArray.get(i);
                thisCardArray = (JSONArray) thisSet.get("cards");
                for (int j = 0; j < thisCardArray.size(); j++)
                {
                    thisCard = (JSONObject) thisCardArray.get(j);

                    preparedStatement.setNull(1, java.sql.Types.INTEGER);

                    String name = (String) thisCard.get("name");
                    System.out.println(name);
                    preparedStatement.setString(2, name);

                    String mana = (String) thisCard.get("manaCost");
                    preparedStatement.setString(3, mana);

                    if (thisCard.get("cmc") != null && thisCard.get("cmc") instanceof Long)
                    {
                        long cMana = (long) thisCard.get("cmc");
                        preparedStatement.setLong(4, cMana);
                    }
                    else if (thisCard.get("cmc") != null && thisCard.get("cmc") instanceof Double)
                    {
                        double cMana = (double) thisCard.get("cmc");
                        preparedStatement.setDouble(4, cMana);
                    }
                    else
                        preparedStatement.setNull(4, java.sql.Types.DECIMAL);

                    String text = (String) thisCard.get("text");
                    preparedStatement.setString(5, text);

                    JSONArray supers = (JSONArray) thisCard.get("supertypes");
                    if (supers != null)
                    {
                        String superTypes = "";
                        for (int a = 0; a < supers.size(); a++)
                        {
                            if (a > 0)
                                superTypes += ", ";
                            superTypes += supers.get(a) + ", ";
                        }
                        preparedStatement.setString(6, superTypes);
                    }
                    else
                        preparedStatement.setNull(6, java.sql.Types.VARCHAR);
                    

                    JSONArray subs = (JSONArray) thisCard.get("subtypes");
                    if (subs != null)
                    {
                        String subTypes = "";
                        
                        for (int s = 0; s < subs.size(); s++)
                        {
                            if (s > 0)
                                subTypes += ", ";
                            subTypes += subs.get(s);
                        }
                        preparedStatement.setString(7, subTypes);
                    }
                    else
                        preparedStatement.setNull(7, java.sql.Types.VARCHAR);

                    
                    if (thisCard.get("power") != null || thisCard.get("toughness") != null)
                    {
                        String powerToughness = (String) thisCard.get("power") + "/" + thisCard.get("toughness");
                        preparedStatement.setString(8, powerToughness);
                    }
                    else
                        preparedStatement.setNull(8, java.sql.Types.VARCHAR);

                    String flavor = (String) thisCard.get("flavor");
                    preparedStatement.setString(9, flavor);

                    String rarity = (String) thisCard.get("rarity");
                    preparedStatement.setString(10, rarity);

                    String artist = (String) thisCard.get("artist");
                    preparedStatement.setString(11, artist);

                    String setName = (String) thisSet.get("name");
                    preparedStatement.setString(12, setName);

                    status = preparedStatement.executeUpdate();
                }
            }
            return status;
        }
        catch (Exception e)
        {
            throw e;
        } 
        finally
        {
            try
            {
                if (connect != null)
                {
                    connect.close();
                }
            }
            catch (Exception e)
            {
                
            }
        }
    }
    
    public int loadRulings()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdbmagic?" + "user=root&password=notmustard");
            System.out.println("Connection successful");
            
            int status = 0;
            preparedStatement = connect.prepareStatement("INSERT INTO Cards VALUES (?, ?, ?)");
            JSONArray setArray = (JSONArray) JSONValue.parse(new FileReader("C:\\Users\\Resu Eman\\Desktop\\allsetsarray.json"));
            JSONArray thisCardArray = null;
            JSONObject thisCard = null;
            JSONObject thisSet = null;
            
            for (int i = 0; i < setArray.size(); i++)
            {
                thisSet = (JSONObject) setArray.get(i);
                thisCardArray = (JSONArray) thisSet.get("cards");
                
                for (int j = 0; j < thisCardArray.size(); j++)
                {
                    thisCard = (JSONObject) thisCardArray.get(j);
                    
                    JSONArray rulingArray = (JSONArray) thisCard.get("rulings");
                    if (rulingArray != null)
                    {
                        String ruling = (String) rulingArray.get(1);
                        preparedStatement.setString(1, ruling);
                        
                        String date = (String) rulingArray.get(2);
                        preparedStatement.setString(2, date);
                        
                        String card = (String) thisCard.get("name");
                        preparedStatement.setString(3, card);
                        
                        status = preparedStatement.executeUpdate();
                    }
                }
            }
            return status;
        }
        catch (Exception e)
        {
            
        }
        finally
        {
            try
            {
                if (connect != null)
                {
                    connect.close();
                }
            }
            catch (Exception e)
            {
                
            }
        }
        return 0;
    }
}
