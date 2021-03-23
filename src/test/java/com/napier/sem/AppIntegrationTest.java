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
        app = new DataConnect();
        app.connect("localhost:33060");
    }

    @Test
    void testGetCity()
    {
        Req7 a = new Req7(app);
        a.cityReport(1);
        City ct = a.Ritorna();
        assertEquals(ct.City_name(), "Mumbai (Bombay)");
        assertEquals(ct.City_country_name(), "IND");
        assertEquals(ct.City_district(), "Maharashtra");
        assertEquals(ct.City_population(), 10500000);
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
