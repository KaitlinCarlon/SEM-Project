package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

enum ReqCityEnum {
    Basic,
    Continent,
    Region,
    Country,
    District
}

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
    public void cityReport(ReqCityEnum req, int limit)
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
