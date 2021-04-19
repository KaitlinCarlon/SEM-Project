package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Requirement 7 to 15 of the SEM Coursework
 * This Class Produce these Reports:
 *
 * Req 17 Report: List all the capital cities in the world organised by largest population to smallest.
 * Reg 20 report: List all the capital cities in the world organised by largest population to smallest with limit rows
 * Reg 18 Report: List all the capital cities in a continent organised by largest population to smallest.
 * Reg 21 Report: List all the capital cities in a continent organised by largest population to smallest with limit rows
 * Reg 19 Report: List all the capital cities in a region organised by largest to smallest.
 * Reg 22 Report: List all the capital cities in a region organised by largest population to smallest with limit rows
 *
 * Function:
 * Init passing the dataConnect from the main connection
 * Method CapitalCityReport giving instruction for limitation or not
 * Retrieve data
 * Rebuild Class
 * Print Data to the Terminal
 *
 * @author Giovanmaria Scanu
 * @developer  Kaitlin Carlon
 */

public class ReqCapitalCity {

    //Variables
    private DataConnect a;
    private City ritorna;
    private String strSelect;

    //Specific String
    private String Continent = "North America";
    private String Region = "Caribbean";

    //Return City for test
    public City Ritorna(){return ritorna;}

    //init
    ReqCapitalCity(DataConnect dataConnect){a = dataConnect;}

    //Retrieve CapitalCityReport
    public void capitalCityReport(Location reg, int limit)
    {
        try
        {
            //Create an SQL statement
            Statement stmt = a.con2().createStatement();
            //Create string for SQL statement

            switch(reg) {
                case Basic:
                    if (limit == 0) {
                        strSelect =
                                "SELECT city.Name, CountryCode, city.Population"
                                        + "FROM city"
                                        + "JOIN country ON Capital = ID "
                                        + "ORDER BY city.Population DESC";
                    }
                    else{
                        strSelect =
                                "SELECT city.Name, CountryCode, city.Population"
                                        + "FROM city"
                                        + "JOIN country ON Capital = ID "
                                        + "ORDER BY city.Population DESC"
                                        + "LIMIT" + limit + "";
                    }
                    break;
                case Continent:
                    if (limit == 0){
                        strSelect =
                                "SELECT city.Name, CountryCode, city.Population"
                                        + "FROM city"
                                        + "JOIN country ON Capital = ID WHERE Continent = '" + Continent + "'"
                                        + "ORDER BY city.Population DESC";
                    }
                    else{
                        strSelect =
                                "SELECT city.Name, CountryCode, city.Population"
                                        + "FROM city"
                                        + "JOIN country ON Capital = ID WHERE Continent = '" + Continent + "'"
                                        + "ORDER BY city.Population DESC"
                                        + "LIMIT" + limit + "";

                    }
                    break;
                case Region:
                    if (limit == 0){
                        strSelect =
                                "SELECT city.Name, CountryCode, city.Population"
                                        + "FROM city"
                                        + "JOIN country ON Capital = ID WHERE Region = '" + Region + "'"
                                        + "ORDER BY city.Population DESC";

                    }
                    else {
                        strSelect =
                                "SELECT city.Name, CountryCode, city.Population"
                                        + "FROM city"
                                        + "JOIN country ON Capital = ID WHERE Region = '" + Region + "'"
                                        + "ORDER BY city.Population DESC"
                                        + "LIMIT" + limit + "";
                    }
                    break;
            }

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned

            while (rset.next())
            {
                City city = new City(rset.getString("Name"), rset.getString("CountryCode"),rset.getInt("Population"));
                ritorna = city;
                //if the data is present

                //show the result on screen
                System.out.println(
                        city.City_name() + " "
                                + city.City_country_name() + " "
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

