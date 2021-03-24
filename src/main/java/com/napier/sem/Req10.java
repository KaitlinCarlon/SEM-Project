package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Requirement 10 and 15 of the SEM Coursework
 * This Class Produce 2 Report:
 * Req 10 Report: List all the cities in the country organised by largest population to smallest.
 * Req 15 Report: List all the cities in the country organised by largest population to smallest with limit rows
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

public class Req10 {

    private DataConnect a;

    Req10(DataConnect dataConnect){ a = dataConnect; }

    public void cityReport(int limit)
    {
        try
        {
            String Country = "AFG";
            // Create an SQL statement
            Statement stmt = a.con2().createStatement();
            // Create string for SQL statement
            String strSelect;
            if(limit == 0){
                strSelect =
                        "SELECT Name, CountryCode, District, Population "
                                + "FROM city "
                                + "WHERE CountryCode = '"+ Country + "' "
                                + "ORDER BY Population DESC";
            }
            else{
                strSelect =
                        "SELECT Name, CountryCode, District, Population "
                                + "FROM city "
                                + "WHERE CountryCode = '"+ Country + "' "
                                + "ORDER BY Population DESC "
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
