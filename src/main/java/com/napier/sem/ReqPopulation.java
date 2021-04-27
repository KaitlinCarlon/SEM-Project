package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.lang.System.*;

import static java.lang.System.out;

/**
 * Requirement 23 to 25 of the SEM Coursework
 * This Class Produce these Reports:
 * Req 23 Report: List the population of people, people living in cities, and people not living in cities in each continent.
 * Req 24 Report: List the population of people, people living in cities, and people not living in cities in each region.
 * Req 25 Report: List the population of people, people living in cities, and people not living in cities in each country.
 *
 * Function:
 * Init passing the dataConnect from the main connection
 * Method ReqPopulation giving instruction for limitation or not
 * Retrieve data
 * Rebuild Class
 * Print Data to the Terminal
 *
 * @author Giovanmaria Scanu
 * @developer  Marcin Ignac
 */

public class ReqPopulation {

//Variables
    private DataConnect a;
    private Population ritorna;
    private String strSelect;

    //Specific String
    private String Continent = "North America";
    private String Region = "Caribbean";

    //Return Population for test
    public Population Ritorna(){return ritorna;}

    //init
    ReqPopulation(DataConnect dataConnect){a = dataConnect;}

    //Retrieve PopulationReports
    public void PopulationReport(Location req)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = a.con2().createStatement();
            // Create string for SQL statement

            switch(req){
                case Basic:
                        strSelect = "SELECT country.Name, SUM(country.Population) as CountryPopulation, SUM(city.Population) AS CityPopulation " +
                                "ROUND(((SUM(city.Population)/SUM(country.Population))*100),2) AS InCityPercentage, " +
                                "SUM(country.Population) - SUM(city.Population) AS NotCity, " +
                                "ROUND(((SUM(country.Population) - SUM(city.Population))/SUM(country.Population)*100),2) AS NotCityPercentage " +
                                "FROM country " +
                                "JOIN city ON city.CountryCode = country.Code " +
                                "GROUP BY country.Code";

            break;
                case Region:
                        strSelect = "SELECT country.Region, SUM(country.Population) as RegionPopulation, SUM(city.Population) AS CityPopulation, " +
                                "ROUND(((SUM(city.Population)/SUM(country.Population))*100),2) AS InCityPercentage, " +
                                "SUM(country.Population) - SUM(city.Population) AS NotCity, " +
                                "ROUND(((SUM(country.Population) - SUM(city.Population))/SUM(country.Population)*100),2) AS NotCityPercentage " +
                                "FROM country " +
                                "JOIN city ON city.CountryCode = country.Code " +
                                "GROUP BY country.Region";

            break;
                case Continent:
                        strSelect = "SELECT country.Continent, SUM(country.Population) as ContinentPopulation, SUM(city.Population) AS CityPopulation, " +
                                "ROUND(((SUM(city.Population)/SUM(country.Population))*100),2) AS InCityPercentage, " +
                                "SUM(country.Population) - SUM(city.Population) AS NotCity, " +
                                "ROUND(((SUM(country.Population) - SUM(city.Population))/SUM(country.Population)*100),2) AS NotCityPercentage " +
                                "FROM country " +
                                "JOIN city ON city.CountryCode = country.Code " +
                                "GROUP BY country.Continent";

                    break;
                }

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
                    while (rset.next())
                    {
                        Population population = new Population(rset.getString("Country Name"), rset.getString("Continent Name"), rset.getString("Region Name"), rset.getInt("Country Population"), rset.getInt("Region Population"), rset.getInt("Continent Population"), rset.getInt(" City Population"), rset.getInt(" Outside City Population"), rset.getFloat("City Percentage"), rset.getFloat("Outside City Percentage"));
                        ritorna = population;
                        //if the data is present

                        //show the result on screen
                        out.println(
                                population.Country_name() + " "
                                        + population.Country_continent() + " "
                                        + population.RegionName() + " "
                                        + population.Country_population() + " "
                                        + population.Region_population() + " "
                                        + population.Continent_population() + " "
                                        + population.City_pop() + " "
                                        + population.NotCity_population() + " "
                                        + population.CityPercentage() + " "
                                        + population.NotCityPercentage() + "\n"

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
