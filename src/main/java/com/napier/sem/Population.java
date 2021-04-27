package com.napier.sem;

public class Population {
    /**
     * Private Variables
     */

    //Country Name
    private String country_name;
    //continent name
    private String country_continent;
    //Country region name
    private String region;
    //Country Population
    private int country_population;
    //region Population
    private int region_population;
    //continent population
    private int continent_population;
    //living in City population
    private int city_population;
    //living outside of city population
    private int notCity_population;
    //percentage in city
    private float cityPercentage;
    //percentage notCity
    private float notCityPercentage;

    /**
     * Init
     */

    Population (String countryName, String continentName, String regionName, int countryPop, int regionPop, int continentPop, int cityPop, int notCityPop, float cityPerc, float notCityPerc){
        this.country_name = countryName;
        this.country_continent = continentName;
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
        return this.country_name;
    }
    public String Country_continent() {return this.country_continent;}
    public String RegionName() {return this.region;}
    public int Country_population(){
        return this.country_population;
    }
    public int Region_population(){
        return this.region_population;
    }
    public int Continent_population() {return this.continent_population;}
    public int City_pop() {return this.city_population;}
    public int NotCity_population() {return this.notCity_population;}
    public float CityPercentage() {return this.cityPercentage;}
    public float NotCityPercentage() {return this.notCityPercentage;}
}
