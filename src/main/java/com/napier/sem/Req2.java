package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Requirement 2 and 5 of the SEM Coursework
 * This Class Produce 2 Report:
 * Req 2 Report: List Country in the continent - largest to smallest.
 * Req 5 Report: List Country in the continent - largest to smallest with limit rows
 *
 * Function:
 * Init passing the dataConnect from the main connection
 * Method countryReport giving instruction for limitation or not
 * Retrieve data
 * Rebuild Class
 * Print Data to the Terminal
 *
 * @author Giovanmaria Scanu
 * @developer Matthew
 */

public class Req2 {
    private DataConnect a;

    Req2(DataConnect dataConnect){
        a = dataConnect;
    }

    public void countryReport(int limit)
    {
        String inputContinent = "'Europe'";
        try
        {
            // Create an SQL statement
            Statement stmt = a.con2().createStatement();

            String strSelect;
            if(limit == 0) {
                // Create string for SQL statement
                strSelect =
                        "SELECT Code, Name, Continent, Region, Population, Capital "
                                + "FROM country "
                                + "WHERE continent = " + inputContinent + ""
                                + "ORDER BY Population DESC";
            } else {
                strSelect =
                        "SELECT Code, Name, Continent, Region, Population, Capital "
                                + "FROM country "
                                + "WHERE continent = " + inputContinent + ""
                                + "ORDER BY Population DESC "
                                + "LIMIT " + limit + "";
            }
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            while (rset.next())
            {
                Country country = new Country(rset.getString("Code"), rset.getString("Name"), rset.getString("Continent"), rset.getString("Region"), rset.getInt("Population"), null);
                //if the data is present

                //Show the result on screen
                System.out.println(
                        country.Country_code()+ " "
                                + country.Country_name() + " "
                                + country.Country_continent() + " "
                                + country.Region() + " "
                                + country.Population() + "\n"
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
