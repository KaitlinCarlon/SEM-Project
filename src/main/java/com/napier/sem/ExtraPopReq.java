package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

import static java.lang.System.*;

/**
 * Requirement 26 to 31 of the SEM Coursework
 * This Class Produce these Reports:
 * Req 26 Report: Access to world population.
 * Req 27 Report: Access to continets population.
 * Req 28 Report: Access to regions population.
 * Req 29 Report: Access to countries population.
 * Req 30 Report: Access to discricts population.
 * Req 31 Report: Access to cities population.
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

public class ExtraPopReq {

    //Variables
    private DataConnect a;
    private long ritorna;
    private String strSelect;


    //Specific String
    private String Continent = "Asia";
    private String Region = "Caribbean";
    private String Country = "Argentina";
    private String District = "Utrecht";
    private String City = "Haag";

    //Return City for test
    public double Ritorna(){
        return ritorna;
    }

    //init
    ExtraPopReq(DataConnect dataConnect){ a = dataConnect; }

    public void totalPop(Location req)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = a.con2().createStatement();
            // Create string for SQL statement

            switch(req){
                case Basic:
                    strSelect = "SELECT SUM(population) AS Population FROM country";
                    break;
                case Continent:
                    strSelect = "SELECT SUM(population) AS Population FROM country WHERE Continent = '" + Continent + "'";
                    break;
                case Region:
                    strSelect = "SELECT SUM(population) AS Population FROM country WHERE Region = '" + Region + "'";
                    break;
                case Country:
                    strSelect = "SELECT SUM(population) AS Population FROM country WHERE Name = '" + Country + "'";
                    break;
                case District:
                    strSelect = "SELECT SUM(Population) AS Population FROM city WHERE District = '" + District + "'";
                    break;
                case City:
                    strSelect = "SELECT Population FROM city WHERE Name = '" + City + "'";
                    break;
            }

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            while (rset.next())
            {
                long population = rset.getLong("Population");
                ritorna = population;
                //if the data is present

                //Show the result on screen
                out.println( population + "\n");
            }
        }
        catch (Exception e)
        {
            out.println(e.getMessage());
            out.println("Failed to get city details");
        }
    }
}
