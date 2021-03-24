package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Requirement 8 and 13 of the SEM Coursework
 * This Class Produce 2 Report:
 * Req 8 Report: List all the cities in the continent organised by largest population to smallest.
 * Req 13 Report: List all the cities in the continent organised by largest population to smallest with limit rows
 *
 * Function:
 * Init passing the dataConnect from the main connection
 * Method cityReport giving instruction for limitation or not
 * Retrieve data
 * Rebuild Class
 * Print Data to the Terminal
 *
 * @author Giovanmaria Scanu
 * @developer  Giovanmaria Scanu
 */

public class Req8 {

    private DataConnect a;

    Req8(DataConnect dataConnect){ a = dataConnect; }

    public void cityReport(int limit)
    {
        try
        {
            String Continent = "North America";
            // Create an SQL statement
            Statement stmt = a.con2().createStatement();
            // Create string for SQL statement
            String strSelect;
            if(limit == 0){
                strSelect =
                        "SELECT city.Name, CountryCode, District, city.Population FROM city " +
                                "JOIN country ON CountryCode = Code WHERE Continent = '"+ Continent +"' " +
                                "ORDER BY city.Population DESC";
            }
            else{
                strSelect =
                        "SELECT city.Name, CountryCode, District, city.Population FROM city " +
                                "JOIN country ON CountryCode = Code WHERE Continent = '"+ Continent +"' " +
                                "ORDER BY city.Population DESC "
                                + "LIMIT " + limit + "";
            }

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            while (rset.next())
            {
                City city = new City(rset.getString("Name"), rset.getString("CountryCode"), rset.getString("District"), rset.getInt("Population")  );

                //if the data is present

                //Show the result on screen
                System.out.println(
                        city.City_name()+ " "
                                + city.City_country_name() + " "
                                + city.City_district() + " "
                                + city.City_population() + "\n"
                );
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
        }
    }

}
