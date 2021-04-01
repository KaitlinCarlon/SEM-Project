package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Requirement 30 of the SEM Coursework
 * This Class Produce these Reports:
 * Number of people and world percentage of Chinese, English, Hindi, Spanish and Arabic language user. Greater to smallest.
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

public class ReqLanguage {

    //Variables
    private DataConnect a;
    private Language ritorna;
    private String strSelect;
    //Accessor
    public Language Ritorna(){return ritorna;}

    //init
    ReqLanguage(DataConnect dataConnect){ a = dataConnect; }

    public void Parlare(){

        try
        {
            // Create an SQL statement
            Statement stmt = a.con2().createStatement();
            // Create string for SQL statement

            strSelect = "SELECT Language, Population, ROUND(((Population * 100)/ Total),2) AS Percentage FROM( SELECT Language, SUM(Population) as Population, (SELECT SUM(population) AS Total FROM country) AS Total FROM ( SELECT CountryCode, Language, ((Population * Percentage)/100) AS Population FROM ( SELECT CountryCode, Language, Population, Percentage FROM countrylanguage JOIN country ON Code = CountryCode) AS T) AS W WHERE Language = 'Chinese' OR Language = 'English' OR Language = 'Hindi' OR Language = 'Spanish' OR Language = 'Arabic' GROUP BY Language ORDER BY Population DESC) AS V";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            while (rset.next())
            {
                Language parl = new Language(rset.getString("Language"), rset.getLong("Population"), rset.getFloat("Percentage"));
                ritorna = parl;
                //if the data is present

                //Show the result on screen
                System.out.println(
                        parl.Lingua()+ " "
                                + parl.Parlare() + " "
                                + parl.Percentuale() + "\n"
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

