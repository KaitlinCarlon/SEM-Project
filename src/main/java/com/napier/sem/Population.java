package com.napier.sem;

public class Population {
    /**
     * Private Variables
     */

    //Country Name
    private String country;
    //continent name
    private String continent;
    //Country region name
    private String region;
    //Country Population
    private long country_population;
    //region Population
    private long region_population;
    //continent population
    private long continent_population;
    //living in City population
    private long city_population;
    //living outside of city population
    private long notCity_population;
    //percentage in city
    private float cityPercentage;
    //percentage notCity
    private float notCityPercentage;

    /**
     * Init
     */

    Population (String countryName, String continentName, String regionName, long countryPop, long regionPop, long continentPop, long cityPop, long notCityPop, float cityPerc, float notCityPerc){
        this.country = countryName;
        this.continent = continentName;
        this.region = regionName;
        this.country_population = countryPop;
        this.region_population = regionPop;
        this.continent_population = continentPop;
        this.city_population = cityPop;
        this.notCity_population = notCityPop;
        this.cityPercentage = cityPerc;
        this.notCityPercentage = notCityPerc;
    }


    /**
     * Accessor : Getter
     */
    public String Country_name(){
        return this.country;
    }
    public String Continent_name() {return this.continent;}
    public String Region_name() {return this.region;}
    public long Country_population(){
        return this.country_population;
    }
    public long Region_population(){
        return this.region_population;
    }
    public long Continent_population() {return this.continent_population;}
    public long City_pop() {return this.city_population;}
    public long NotCity_population() {return this.notCity_population;}
    public float CityPercentage() {return this.cityPercentage;}
    public float NotCityPercentage() {return this.notCityPercentage;}
}
