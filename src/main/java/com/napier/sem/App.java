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
        System.out.println( "Country Report \n" );
        System.out.println( "Full List \n" );
        a.country.countryReport(Location.Basic, 0 );
        System.out.println( "Limit 1 \n" );
        a.country.countryReport(Location.Basic, 1 );
        System.out.println( "Continent: North America \n" );
        System.out.println( "Full List \n" );
        a.country.countryReport(Location.Continent, 0);
        System.out.println( "Limit 1 \n" );
        a.country.countryReport(Location.Continent, 1);
        System.out.println( "Region: Caribbean\n" );
        System.out.println( "Full List \n" );
        a.country.countryReport(Location.Region, 0 );
        System.out.println( "Limit 1 \n" );
        a.country.countryReport(Location.Region, 1 );

        //City Reports
        System.out.println( "City Report \n" );
        System.out.println( "Full List \n" );
        a.city.cityReport(Location.Basic, 0 );
        System.out.println( "Limit 1 \n" );
        a.city.cityReport(Location.Basic, 1 );
        System.out.println( "Continent: North America\n" );
        System.out.println( "Full List \n" );
        a.city.cityReport(Location.Continent, 0);
        System.out.println( "Limit 1 \n" );
        a.city.cityReport(Location.Continent, 1 );
        System.out.println( "Region: Caribbean\n" );
        System.out.println( "Full List \n" );
        a.city.cityReport(Location.Region, 0 );
        System.out.println( "Limit 1 \n" );
        a.city.cityReport(Location.Region, 1 );
        System.out.println( "Country: AFG\n" );
        System.out.println( "Full List \n" );
        a.city.cityReport(Location.Country, 0 );
        System.out.println( "Limit 1 \n" );
        a.city.cityReport(Location.Country,  1);
        System.out.println( "District: Buenos Aires\n" );
        System.out.println( "Full List \n" );
        a.city.cityReport(Location.District, 0 );
        System.out.println( "Limit 1 \n" );
        a.city.cityReport(Location.District, 5 );


        //Extra Population Request
        System.out.println( "Extra Population Report \n" );
        System.out.println( "Full List \n" );
        a.total.totalPop(Location.Basic);
        System.out.println( "Continent: Asia\n" );
        a.total.totalPop(Location.Continent);
        System.out.println( "Region : Caribbean\n" );
        a.total.totalPop(Location.Region);
        System.out.println( "Country: Argentina\n" );
        a.total.totalPop(Location.Country);
        System.out.println( "District: Utrecht\n" );
        a.total.totalPop(Location.District);
        System.out.println( "City Haag\n" );
        a.total.totalPop(Location.City);
        System.out.println( "\n" );

        //Language
        System.out.println( "Language and Percentage \n" );
        a.linguaggio.Parlare();

        //Capital City Reports
        System.out.println( "Capital City \n" );
        System.out.println( "Full List \n" );
        a.capCity.capitalCityReport(Location.Basic,0);
        System.out.println( "Limit 1 \n" );
        a.capCity.capitalCityReport(Location.Basic,1);
        System.out.println( "Continent: North America\n" );
        System.out.println( "Full List \n" );
        a.capCity.capitalCityReport(Location.Continent,0);
        System.out.println( "Limit 1 \n" );
        a.capCity.capitalCityReport(Location.Continent,1);
        System.out.println( "Region: Caribbean\n" );
        System.out.println( "Full List \n" );
        a.capCity.capitalCityReport(Location.Region,0);
        System.out.println( "Limit 1 \n" );
        a.capCity.capitalCityReport(Location.Region,1);

        // Disconnect from database
        a.a.disconnect();
    }
}