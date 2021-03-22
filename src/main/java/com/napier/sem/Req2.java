package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

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
                Country country = new Country();
                country.country_code = rset.getString("Code");
                country.country_name = rset.getString("Name");
                country.country_continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");


                //if the data is present

                //Show the result on screen
                System.out.println(
                        country.country_code+ " "
                                + country.country_name + " "
                                + country.country_continent + " "
                                + country.region + " "
                                + country.population + "\n"
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
