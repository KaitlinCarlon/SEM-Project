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


enum Location {
    Basic,
    Continent,
    Region,
    Country,
    District
}

public class App
{

    DataConnect a = new DataConnect();
    Req1 first = new Req1(a);
    Req2 second = new Req2(a);
    Req3 third = new Req3(a);   

    Location cityEnum;
    ReqCity city = new ReqCity(a);


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

        //City Reports
        a.city.cityReport(a.cityEnum = Location.Basic, 0 );
        a.city.cityReport(a.cityEnum = Location.Basic, 1 );
        a.city.cityReport(a.cityEnum = Location.Continent, 0);
        a.city.cityReport(a.cityEnum = Location.Continent, 1 );
        a.city.cityReport(a.cityEnum = Location.Region, 0 );
        a.city.cityReport(a.cityEnum = Location.Region, 1 );
        a.city.cityReport(a.cityEnum = Location.Country, 0 );
        a.city.cityReport(a.cityEnum = Location.Country,  1);
        a.city.cityReport(a.cityEnum = Location.District, 0 );
        a.city.cityReport(a.cityEnum = Location.District, 1 );

        // Disconnect from database
        a.a.disconnect();
    }
}