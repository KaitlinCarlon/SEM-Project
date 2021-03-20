/*
This is the Main App which connect to the World Database
This is a sample connection to be used as reference for the next issues
Divided into this methods:
connect : for the connection to the database
disconnect : to drop the communication whit the database
getCity: which consent to retrieve the data from the World Database
displayCity: print the result of the method getCity in the terminal
main: execution of the methods to be compiled

@author (Giovanmaria Scanu)
 */

package com.napier.sem;

import java.sql.*;

public class App
{

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "group9");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public void countryReport()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            while (rset.next())
            {
                Country emp = new Country();
                emp.country_code = rset.getString("Code");
                emp.country_name = rset.getString("Name");
                emp.country_continent = rset.getString("Continent");
                emp.region = rset.getString("Region");
                emp.population = rset.getInt("Population");


                //if the data is present

                    //Show the result on screen
                    System.out.println(
                            emp.country_code+ " "
                                    + emp.country_name + " "
                                    + emp.country_continent + "\n"
                                    + emp.region + "\n"
                                    + emp.population + "\n"
                    );
                }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
        }
    }

    public void displayCountry(Country emp)
    {
        //if the data is present
        if (emp != null)
        {
            //Show the result on screen
            System.out.println(
                    emp.country_code+ " "
                            + emp.country_name + " "
                            + emp.country_continent + "\n"
                            + emp.region + "\n"
                            + emp.population + "\n"
                            );
        }
    }

    public static void displayMenu()
    {
        System.out.println("Enter Selection\n");
        System.out.println("1. Country Report.\n");
        System.out.println("2. City Report.\n");
        System.out.println("3. Capital City Report.\n");
        System.out.println("4. Population Report.\n");
    }

    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Get Employee
         a.countryReport();
        // Display results
        //a.displayCountry(emp);

        // Disconnect from database
        a.disconnect();
    }
}