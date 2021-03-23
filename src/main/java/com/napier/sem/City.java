package com.napier.sem;

/**
 * This is the City Class Containing all the Data available
 * from the World Database

 * For more information use the Database Tables.PNG in the Database Folder

 * @author (Giovanmaria Scanu)
 */

public class City {

    /**
     * Private Variables
     */
    //City Name
    private String city_name;
    //City Country Code
    private String city_country_code;
    //City District
    private String city_district;
    //City Population
    private int city_population;

    /**
     * Init
     */
    City (String name, String country, String district, int pop){
        this.city_name = name;
        this.city_country_code = country;
        this.city_district = district;
        this.city_population = pop;
    }

    /**
     * Accessor : Getter
     */
    public String City_name(){
        return this.city_name;
    }
    public String City_country_name(){
        return this.city_country_code;
    }
    public String City_district(){
        return this.city_district;
    }
    public int City_population(){
        return this.city_population;
    }
}
