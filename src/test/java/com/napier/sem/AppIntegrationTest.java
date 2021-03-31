package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static DataConnect app;

    @BeforeAll
    static void init()
    {
        //Connection
        app = new DataConnect();
        app.connect("localhost:33060");

    }

    @Test
    void testGetCity()
    {
        ReqCity city = new ReqCity(app);
        ReqCityEnum cityEnum;

        //City Reports

        /**
         * Mumbai (Bombay) IND Maharashtra 10500000
         *
         * Ciudad de México MEX Distrito Federal 8591309
         *
         * La Habana CUB La Habana 2256000
         *
         * Kabul AFG Kabol 1780000
         *
         * La Matanza ARG Buenos Aires 1266461
         */

        //Basic
        city.cityReport(cityEnum = ReqCityEnum.Basic, 1 );
        City basic = city.Ritorna();
        //Assert Basic
        assertEquals(basic.City_name(), "Mumbai (Bombay)");
        assertEquals(basic.City_country_name(), "IND");
        assertEquals(basic.City_district(), "Maharashtra");
        assertEquals(basic.City_population(), 10500000);

        //Continent
        city.cityReport(cityEnum = ReqCityEnum.Continent, 1 );
        City continent = city.Ritorna();
        //Assert Continent
        assertEquals(continent.City_name(), "Ciudad de México");
        assertEquals(continent.City_country_name(), "MEX");
        assertEquals(continent.City_district(), "Distrito Federal");
        assertEquals(continent.City_population(), 8591309);

        //Region
        city.cityReport(cityEnum = ReqCityEnum.Region, 1 );
        City region = city.Ritorna();
        //Assert Region
        assertEquals(region.City_name(), "La Habana");
        assertEquals(region.City_country_name(), "CUB");
        assertEquals(region.City_district(), "La Habana");
        assertEquals(region.City_population(), 2256000);

        //Country
        city.cityReport(cityEnum = ReqCityEnum.Country, 1 );
        City country = city.Ritorna();
        //Assert Country
        assertEquals(country.City_name(), "Kabul");
        assertEquals(country.City_country_name(), "AFG");
        assertEquals(country.City_district(), "Kabol");
        assertEquals(country.City_population(), 1780000);

        //District
        city.cityReport(cityEnum = ReqCityEnum.District, 1 );
        City district = city.Ritorna();
        //Assert District
        assertEquals(district.City_name(), "La Matanza");
        assertEquals(district.City_country_name(), "ARG");
        assertEquals(district.City_district(), "Buenos Aires");
        assertEquals(district.City_population(), 1266461);
    }

    @Test
    void testGetCountry()
    {
        Req1 a = new Req1(app);
        a.countryReport(1);
        Country ct = a.Ritorna();

        assertEquals(ct.Country_code(), "CHN");
        assertEquals(ct.Country_name(), "China");
        assertEquals(ct.Country_continent(), "Asia");
        assertEquals(ct.Region(), "Eastern Asia");
        assertEquals(ct.Population(), 1277558000);
    }
}
