package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Requirement 1 and 4 of the SEM Coursework
 * This Class Produce 2 Report:
 * Req 1 Report: List Country in the World - largest to smallest.
 * Req 4 Report: List Country in the World - largest to smallest with limit rows
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

public class Req1 {

    private DataConnect a;

    Req1(DataConnect dataConnect){
        a = dataConnect;
    }

    public void countryReport(int limit)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = a.con2().createStatement();
            String strSelect;
            if(limit == 0) {
                //create string for sql statement
                strSelect =
                        "SELECT Code, Name, Continent, Region, Population, Capital "
                                + "FROM country "
                                + "ORDER BY Population DESC";
            } else {
                //create string for sql statement
                strSelect =
                        "SELECT Code, Name, Continent, Region, Population, Capital "
                                + "FROM country "
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
