package com.napier.sem;

import sun.awt.geom.AreaOp;

import static java.lang.System.*;

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
    District,
    City
}

public class App
{

    //Create a connection
    DataConnect a = new DataConnect();
    Location cityEnum;
    //Country Report
    ReqCountry country = new ReqCountry(a);
    //City Report
    ReqCity city = new ReqCity(a);
    //Extra Population
    ExtraPopReq total = new ExtraPopReq(a);
    //Language
    ReqLanguage linguaggio = new ReqLanguage(a);
    //Capital City Report
    ReqCapitalCity capCity = new ReqCapitalCity(a);
    ReqPopulation pop = new ReqPopulation(a);


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
        //Country Reports
        out.println( "Country Report \n" );
        out.println( "Full List \n" );
        a.country.countryReport(Location.Basic, 0 );
        out.println( "Limit 1 \n" );
        a.country.countryReport(Location.Basic, 1 );
        out.println( "Continent: North America \n" );
        out.println( "Full List \n" );
        a.country.countryReport(Location.Continent, 0);
        out.println( "Limit 1 \n" );
        a.country.countryReport(Location.Continent, 1);
        out.println( "Region: Caribbean\n" );
        out.println( "Full List \n" );
        a.country.countryReport(Location.Region, 0 );
        out.println( "Limit 1 \n" );
        a.country.countryReport(Location.Region, 1 );

        //City Reports
        out.println( "City Report \n" );
        out.println( "Full List \n" );
        a.city.cityReport(Location.Basic, 0 );
        out.println( "Limit 1 \n" );
        a.city.cityReport(Location.Basic, 1 );
        out.println( "Continent: North America\n" );
        out.println( "Full List \n" );
        a.city.cityReport(Location.Continent, 0);
        out.println( "Limit 1 \n" );
        a.city.cityReport(Location.Continent, 1 );
        out.println( "Region: Caribbean\n" );
        out.println( "Full List \n" );
        a.city.cityReport(Location.Region, 0 );
        out.println( "Limit 1 \n" );
        a.city.cityReport(Location.Region, 1 );
        out.println( "Country: AFG\n" );
        out.println( "Full List \n" );
        a.city.cityReport(Location.Country, 0 );
        out.println( "Limit 1 \n" );
        a.city.cityReport(Location.Country,  1);
        out.println( "District: Buenos Aires\n" );
        out.println( "Full List \n" );
        a.city.cityReport(Location.District, 0 );
        out.println( "Limit 1 \n" );
        a.city.cityReport(Location.District, 1 );


        //Extra Population Request
        out.println( "Extra Population Report \n" );
        out.println( "Full List \n" );
        a.total.totalPop(Location.Basic);
        out.println( "Continent: Asia\n" );
        a.total.totalPop(Location.Continent);
        out.println( "Region : Caribbean\n" );
        a.total.totalPop(Location.Region);
        out.println( "Country: Argentina\n" );
        a.total.totalPop(Location.Country);
        out.println( "District: Utrecht\n" );
        a.total.totalPop(Location.District);
        out.println( "City Haag\n" );
        a.total.totalPop(Location.City);
        out.println( "\n" );

        //Language
        out.println( "Language and Percentage \n" );
        a.linguaggio.Parlare();

        //Capital City Reports
        out.println( "Capital City \n" );
        out.println( "Full List \n" );
        a.capCity.capitalCityReport(Location.Basic,0);
        out.println( "Limit 1 \n" );
        a.capCity.capitalCityReport(Location.Basic,1);
        out.println( "Continent: North America\n" );
        out.println( "Full List \n" );
        a.capCity.capitalCityReport(Location.Continent,0);
        out.println( "Limit 1 \n" );
        a.capCity.capitalCityReport(Location.Continent,1);
        out.println( "Region: Caribbean\n" );
        out.println( "Full List \n" );
        a.capCity.capitalCityReport(Location.Region,0);
        out.println( "Limit 1 \n" );
        a.capCity.capitalCityReport(Location.Region,1);

        /**
         * //Population
         *         out.println("Population and Percentage of people living in cities and outside them \n" );
         *         out.println("Country Population \n");
         *         out.println( "Full List \n" );
         *         a.pop.PopulationReport(Location.Basic);
         *         out.println("Region Population \n");
         *         out.println( "Full List \n" );
         *         a.pop.PopulationReport(Location.Region);
         *         out.println("Continent Population \n");
         *         out.println( "Full List \n" );
         *         a.pop.PopulationReport(Location.Continent);
         */


        // Disconnect from database
        a.a.disconnect();
    }
}