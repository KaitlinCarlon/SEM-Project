package com.napier.sem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.*;

/**
 * This Class has been separated to encapsulate and deal with the connection to the database
 * for and easy and efficient utilization in the main and secondary code.
 * Activity:
 * Connection
 * Return of Data
 * Disconnection
 * @author Giovanmaria Scanu
 */

public class DataConnect {

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connection con getter
     */
    public Connection con2(){
        return con;
    }

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            out.println("Could not load SQL driver");
            exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                // Old
                //con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "group9");

                //Integration Testing
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "group9");

                out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                out.println("Failed to connect to database attempt " + Integer.toString(i));
                out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                out.println("Thread interrupted? Should not happen.");
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
                out.println("Error closing connection to database");
            }
        }
    }
}
