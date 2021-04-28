package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

import static java.lang.System.*;

/**
 * Requirement 7 to 15 of the SEM Coursework
 * This Class Produce these Reports:
 * Req 7 Report: List all the cities in the world organised by largest population to smallest.
 * Req 12 Report: List all the cities in the world organised by largest population to smallest with limit rows
 * Req 8 Report: List all the cities in the continent organised by largest population to smallest.
 * Req 13 Report: List all the cities in the continent organised by largest population to smallest with limit rows
 * Req 9 Report: List all the cities in the region organised by largest population to smallest.
 * Req 14 Report: List all the cities in the region organised by largest population to smallest with limit rows
 * Req 10 Report: List all the cities in the country organised by largest population to smallest.
 * Req 15 Report: List all the cities in the country organised by largest population to smallest with limit rows
 * Req 11 Report: List all the cities in the district organised by largest population to smallest.
 * Req 16 Report: List all the cities in the district organised by largest population to smallest with limit rows
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

public class ReqCity {

    //Variables
    private DataConnect a;
    private City ritorna;
    private String strSelect;

    //Specific String
    private String Continent = "North America";
    private String Region = "Caribbean";
    private String Country = "AFG";
    private String District = "Buenos Aires";

    //Return City for test
    public City Ritorna(){
        return ritorna;
    }

    //init
    ReqCity(DataConnect dataConnect){ a = dataConnect; }

    //Retrieve CityReport
    public void cityReport(Location req, int limit)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = a.con2().createStatement();
            // Create string for SQL statement

            switch(req){
                case Basic:
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
                    break;
                case Continent:
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
                    break;
                case Region:
                    if(limit == 0){
                        strSelect =
                                "SELECT city.Name, CountryCode, District, city.Population FROM city " +
                                        "JOIN country ON CountryCode = Code WHERE Region = '"+ Region +"' " +
                                        "ORDER BY city.Population DESC";
                    }
                    else{
                        strSelect =
                                "SELECT city.Name, CountryCode, District, city.Population FROM city " +
                                        "JOIN country ON CountryCode = Code WHERE Region = '"+ Region +"' " +
                                        "ORDER BY city.Population DESC "
                                        + "LIMIT " + limit + "";
                    }
                    break;
                case Country:
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
                    break;
                case District:
                    if(limit == 0){
                        strSelect =
                                "SELECT * FROM city WHERE District = '"+ District +"' ORDER BY Population DESC";
                    }
                    else{
                        strSelect =
                                "SELECT * FROM city WHERE District = '"+ District +"' ORDER BY Population DESC "
                                        + "LIMIT " + limit + "";
                    }
                    break;
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
                out.println(
                        city.City_name()+ " "
                                + city.City_country_name() + " "
                                + city.City_district() + " "
                                + city.City_population() + "\n"
                );
            }
        }
        catch (Exception e)
        {
            out.println(e.getMessage());
            out.println("Failed to get city details");
        }
    }

}
