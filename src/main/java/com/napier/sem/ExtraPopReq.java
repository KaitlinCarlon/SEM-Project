package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

public class ExtraPopReq {

    //Variables
    private DataConnect a;
    private long ritorna;
    private String strSelect;


    //Specific String
    private String Continent = "Asia";
    private String Region = "Caribbean";
    private String Country = "Argentina";
    private String District = "Utrecht";
    private String City = "Haag";

    //Return City for test
    public double Ritorna(){
        return ritorna;
    }

    //init
    ExtraPopReq(DataConnect dataConnect){ a = dataConnect; }

    public void totalPop(Location req)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = a.con2().createStatement();
            // Create string for SQL statement

            switch(req){
                case Basic:
                    strSelect = "SELECT SUM(population) AS Population country";
                    break;
                case Continent:
                    strSelect = "SELECT SUM(population) AS Population FROM country WHERE Continent = '" + Continent + "'";
                    break;
                case Region:
                    strSelect = "SELECT SUM(population) AS Population FROM country WHERE Region = '" + Region + "'";
                    break;
                case Country:
                    strSelect = "SELECT SUM(population) AS Population FROM country WHERE Name = '" + Country + "'";
                    break;
                case District:
                    strSelect = "SELECT SUM(Population) AS Population FROM city WHERE District = '" + District + "'";
                    break;
                case City:
                    strSelect = "SELECT Population FROM city WHERE Name = '" + City + "'";
                    break;
            }

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            while (rset.next())
            {
                long population = rset.getLong("Population");
                ritorna = population;
                //if the data is present

                //Show the result on screen
                System.out.println( population + "\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
        }
    }
}
