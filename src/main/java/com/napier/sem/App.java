package com.napier.sem;

/**
 * Release 1.0.2.1
    -This is the Main App which connect to the World Database
    -This is a sample connection to be used as reference for the next issues
    -Divided into this methods:
      Connect : for the connection to the database
      Disconnect : to drop the communication whit the database
      getCity: which consent to retrieve the data from the World Database
      displayCity: print the result of the method getCity in the terminal
      main: execution of the methods to be compiled
 * Release 1.0.3.1
   Development Update:
   -Introduction of a new Class for the connection to the Database: DataConnect
   -Encapsulation for the retrieve data for the requirements 1 to 16
   -Modification of the public variables to private for the City and Country Variables Class ( Accessor )
   -Test unit Implementation

 @author (Giovanmaria Scanu)
 */

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
        //Old
        //a.a.connect();
        //Integration Testing
        a.a.connect("localhost:33060");

        // Get Data

        a.first.countryReport(0);
        a.first.countryReport(3);
        a.second.countryReport(0);
        a.second.countryReport(3);
        a.third.countryReport(0);
        a.third.countryReport(3);
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