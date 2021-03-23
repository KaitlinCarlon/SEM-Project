package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class AppTest
{
    /**
     * City Class Test
     */
    //Create a city object
    static City citta;
    //Variables for assertion
    static String name = "Ittiri";
    static String stato = "Italia";
    static String district = "Sardegna";
    static int population = 1640000;

    /**
     * Country Class Test
     */
    //Create a country object
    static Country country;
    //Variables for assertion
    static private String country_code = "ITA";
    static private String country_name = "Italia";
    static private String country_continent = "Europa";
    static private String region =  "Mediterraneo";
    static private int popolazione = 60360000;
    static private String capital = "Ittiri";

    //Initialization
    @BeforeAll
    static void init(){
        /**
         * City Class Test
         */
        citta = new City("Ittiri", "Italia", "Sardegna", 1640000);
        /**
         * Country Class Test
         */
        country = new Country("ITA", "Italia", "Europa", "Mediterraneo", 60360000, "Ittiri");
    }

    @Test
    void unitTest()
    {
        //Assert the class is not null
        assertNotNull(citta);
        //Assert Data is equal to the Init Data via City Class Getter
        assertEquals(citta.City_name(), name);
        assertEquals(citta.City_country_name(), stato);
        assertEquals(citta.City_district(), district);
        assertEquals(citta.City_population(), population);

        /**
         * Country Class Test
         */
        //Assert the class is not null
        assertNotNull(country);
        //Assert Data is equal to the Init Data via Country Class Getter
        assertEquals(country.Country_code(), country_code);
        assertEquals(country.Country_name(), country_name);
        assertEquals(country.Country_continent(), country_continent);
        assertEquals(country.Region(), region);
        assertEquals(country.Population(), popolazione);
        assertEquals(country.Capital(), capital);
    }
}


