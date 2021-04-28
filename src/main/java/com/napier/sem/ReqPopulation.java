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
                    strSelect = "SELECT country.Name, SUM(country.Population) as CountryPopulation, SUM(city.Population) AS CityPopulation, " +
                            "ROUND(((SUM(city.Population)/SUM(country.Population))*100),2) AS InCityPercentage, " +
                            "SUM(country.Population) - SUM(city.Population) AS NotCity, " +
                            "ROUND(((SUM(country.Population) - SUM(city.Population))/SUM(country.Population)*100),2) AS NotCityPercentage " +
                            "FROM country " +
                            "JOIN city ON city.CountryCode = country.Code " +
                            "GROUP BY country.Name";

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
                switch(req){
                    case Basic:
                        Population population_basic = new Population(rset.getString("Name"), null, null, rset.getLong("CountryPopulation"), 0, 0, rset.getLong("CityPopulation"), rset.getLong("NotCity"), rset.getFloat("InCityPercentage"), rset.getFloat("NotCityPercentage"));
                        ritorna = population_basic;
                        //if the data is present

                        //show the result on screen
                        out.println(
                                population_basic.Country_name() + " "
                                        + population_basic.Country_population() + " "
                                        + population_basic.City_pop() + " "
                                        + population_basic.NotCity_population() + " "
                                        + population_basic.CityPercentage() + " "
                                        + population_basic.NotCityPercentage() + "\n"

                        );
                        break;
                    case Continent:
                        Population population_continent = new Population(null, rset.getString("Continent"), null, 0, 0, rset.getLong("ContinentPopulation"), rset.getLong("CityPopulation"), rset.getLong("NotCity"), rset.getFloat("InCityPercentage"), rset.getFloat("NotCityPercentage"));
                        ritorna = population_continent;
                        //if the data is present

                        //show the result on screen
                        out.println(
                                population_continent.Continent_name() + " "
                                        + population_continent.Continent_population() + " "
                                        + population_continent.City_pop() + " "
                                        + population_continent.NotCity_population() + " "
                                        + population_continent.CityPercentage() + " "
                                        + population_continent.NotCityPercentage() + "\n"

                        );
                        break;
                    case Region:
                        Population population_region = new Population(null, null, rset.getString("Region"), 0, rset.getLong("RegionPopulation"), 0, rset.getLong("CityPopulation"), rset.getLong("NotCity"), rset.getFloat("InCityPercentage"), rset.getFloat("NotCityPercentage"));
                        ritorna = population_region;
                        //if the data is present

                        //show the result on screen
                        out.println(
                                population_region.Region_name() + " "
                                        + population_region.Region_population() + " "
                                        + population_region.City_pop() + " "
                                        + population_region.NotCity_population() + " "
                                        + population_region.CityPercentage() + " "
                                        + population_region.NotCityPercentage() + "\n"

                        );
                        break;
                }
            }
        }
        catch (Exception e)
        {
            out.println(e.getMessage());
            out.println("Failed to get city details");
        }
    }

}
