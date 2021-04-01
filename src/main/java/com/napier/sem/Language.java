package com.napier.sem;

/**
 * This is the Language Class Containing all the Data available
 * from the World Database

 * For more information use the Database Tables.PNG in the Database Folder

 * @author (Giovanmaria Scanu)
 */

public class Language {

    /**
     * Private Variables
     */
    private String language;
    private long speakers;
    private float percentage;

    /**
     * Init
     */
    Language (String lang, long speak, float perc){
        this.language = lang;
        this.speakers = speak;
        this.percentage = perc;
    }

    /**
     * Accessor : Getter
     */
    public String Lingua(){return this.language;}
    public long Parlare(){return this.speakers;}
    public float Percentuale(){return this.percentage;}


}
