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
    Req2 second = new Req2(a);
    Req3 third = new Req3(a);   
    Req7 seven = new Req7(a);
    Req8 eight = new Req8(a);
    Req9 nine = new Req9(a);
    Req10 ten = new Req10(a);
    Req11 eleven = new Req11(a);

    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.a.connect();

        // Get Data

        a.first.countryReport(0);
        a.first.countryReport(3);
        a.second.countryReport();

        a.third.countryReport();

        a.seven.cityReport(0);
        a.seven.cityReport(3);
        a.eight.cityReport(0);
        a.eight.cityReport(3);
        a.nine.cityReport(0);
        a.nine.cityReport(3);
        a.ten.cityReport(0);
        a.ten.cityReport(3);
        a.eleven.cityReport(0);
        a.eleven.cityReport(3);


        // Disconnect from database
        a.a.disconnect();
    }
}