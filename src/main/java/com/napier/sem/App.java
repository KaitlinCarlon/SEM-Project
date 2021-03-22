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

    DataConnect a = new DataConnect();
    Req1 first = new Req1(a);
    Req7 seven = new Req7(a);

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
        a.a.connect();

        // Get Data
        a.first.countryReport();
        a.seven.cityReport();

        // Disconnect from database
        a.a.disconnect();
    }
}