package com.napier.sem;

/**
 * This is the Country Class Containing all the Data available
 * from the World Database

 * For more information use the Database Tables.PNG in the Database Folder

 * @author (Giovanmaria Scanu)
 */

public class Country {

    /**
     * Private Variables
     */
    //Country Code
    private String country_code;
    //Country Name
    private String country_name;
    //country continent
    private String country_continent;
    //Country region
    private String region;
    //Country Population
    private int population;
    //Country Capital
    private String capital;

    /**
     * Init
     */
    Country(String code, String name, String continent, String region, int pop, String capital){
        this.country_code = code;
        this.country_name = name;
        this.country_continent = continent;
        this.region = region;
        this.population = pop;
        this.capital = capital;
    }

    /**
     * Accessor : Getter
     */
    public String Country_code(){
        return this.country_code;
    }
    public String Country_name(){
        return this.country_name;
    }
    public String Country_continent(){
        return this.country_continent;
    }
    public String Region(){
        return this.region;
    }
    public int Population(){
        return this.population;
    }
    public String Capital(){
        return this.capital;
    }

}
