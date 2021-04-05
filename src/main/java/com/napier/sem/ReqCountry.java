package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Requirement 1 to 6 of the SEM Coursework
 * This Class Produce these Reports:
 * Req 1 Report: List Country in the World - largest to smallest.
 * Req 4 Report: List Country in the World - largest to smallest with limit rows
 * Req 2 Report: List Country in the continent - largest to smallest.
 * Req 5 Report: List Country in the continent - largest to smallest with limit rows
 * Req 3 Report: List Country in the Region - largest to smallest.
 * Req 6 Report: List Country in the Region - largest to smallest with limit rows
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

public class ReqCountry {

    //Variables
    private DataConnect a;
    private Country ritorna;
    private String strSelect;

    //Specific String
    private String Continent = "North America";
    private String Region = "Caribbean";


    //Return Country for test
    public Country Ritorna(){
        return ritorna;
    }

    //init
    ReqCountry(DataConnect dataConnect){ a = dataConnect; }

    //Retrieve CityReport
    public void countryReport(Location req, int limit)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = a.con2().createStatement();
            // Create string for SQL statement

            switch(req) {
                case Basic:
                    if (limit == 0) {
                        strSelect =
                                "SELECT Code, Name, Continent, Region, Population, Capital "
                                        + "FROM country "
                                        + "ORDER BY Population DESC";
                    } else {
                        strSelect =
                                "SELECT Code, Name, Continent, Region, Population, Capital "
                                        + "FROM country "
                                        + "ORDER BY Population DESC "
                                        + "LIMIT " + limit + "";
                    }
                    break;
                case Continent:
                    if (limit == 0) {
                        strSelect =
                                "SELECT Code, Name, Continent, Region, Population, Capital "
                                        + "FROM country "
                                        + "WHERE continent = '" + Continent + "' "
                                        + "ORDER BY Population DESC";
                    } else {
                        strSelect =
                                "SELECT Code, Name, Continent, Region, Population, Capital "
                                        + "FROM country "
                                        + "WHERE continent = '" + Continent + "' "
                                        + "ORDER BY Population DESC "
                                        + "LIMIT " + limit + "";
                    }
                    break;
                case Region:
                    if (limit == 0) {
                        strSelect =
                                "SELECT Code, Name, Continent, Region, Population, Capital "
                                        + "FROM country "
                                        + "WHERE region = '" + Region + "' "
                                        + "ORDER BY Population DESC";
                    } else {
                        strSelect =
                                "SELECT Code, Name, Continent, Region, Population, Capital "
                                        + "FROM country "
                                        + "WHERE region = '" + Region + "' "
                                        + "ORDER BY Population DESC "
                                        + "LIMIT " + limit + "";
                    }
            }

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            while (rset.next())
            {
                Country country = new Country(rset.getString("Code"), rset.getString("Name"), rset.getString("Continent"), rset.getString("Region"), rset.getInt("Population"), null);
                ritorna = country;
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
