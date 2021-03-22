package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Req1 {

    private DataConnect a;

    Req1(DataConnect dataConnect){
        a = dataConnect;
    }

    public void countryReport()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = a.con2().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            while (rset.next())
            {
                Country country = new Country();
                country.country_code = rset.getString("Code");
                country.country_name = rset.getString("Name");
                country.country_continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");


                //if the data is present

                //Show the result on screen
                System.out.println(
                        country.country_code+ " "
                                + country.country_name + " "
                                + country.country_continent + " "
                                + country.region + " "
                                + country.population + "\n"
                );
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
        }
    }

}
