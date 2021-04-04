package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

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
    public void countryReport(Cntry req, int limit)
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
                                        + "WHERE continent = " + Continent + " "
                                        + "ORDER BY Population DESC";
                    } else {
                        strSelect =
                                "SELECT Code, Name, Continent, Region, Population, Capital "
                                        + "FROM country "
                                        + "WHERE continent = " + Continent + ""
                                        + "ORDER BY Population DESC "
                                        + "LIMIT " + limit + "";
                    }
                    break;
                case Region:
                    if (limit == 0) {
                        strSelect =
                                "SELECT Code, Name, Continent, Region, Population, Capital "
                                        + "FROM country "
                                        + "WHERE region = " + Region + ""
                                        + "ORDER BY Population DESC";
                    } else {
                        strSelect =
                                "SELECT Code, Name, Continent, Region, Population, Capital "
                                        + "FROM country "
                                        + "WHERE region = " + Region + ""
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
