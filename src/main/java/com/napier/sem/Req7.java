package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Requirement 7 and 12 of the SEM Coursework
 * This Class Produce 2 Report:
 * Req 7 Report: List all the cities in the world organised by largest population to smallest.
 * Req 12 Report: List all the cities in the world organised by largest population to smallest with limit rows
 *
 * Function:
 * Init passing the dataConnect from the main connection
 * Method cityReport giving instruction for limitation or not
 * Retrieve data
 * Rebuild Class
 * Print Data to the Terminal
 *
 * @author Giovanmaria Scanu
 * @developer  Giovanmaria Scanu - Matthew
 */

public class Req7 {

    private DataConnect a;

    private City ritorna;

    public City Ritorna(){
        return ritorna;
    }

    Req7(DataConnect dataConnect){ a = dataConnect; }

    public void cityReport(int limit)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = a.con2().createStatement();
            // Create string for SQL statement
            String strSelect;
            if(limit == 0){
                strSelect =
                        "SELECT Name, CountryCode, District, Population "
                        + "FROM city "
                        + "ORDER BY Population DESC";
            }
            else{
                strSelect =
                        "SELECT Name, CountryCode, District, Population "
                        + "FROM city "
                        + "ORDER BY Population DESC "
                        + "LIMIT " + limit + "";
            }

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            while (rset.next())
            {
                City city = new City(rset.getString("Name"), rset.getString("CountryCode"), rset.getString("District"), rset.getInt("Population")  );
                ritorna = city;
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
