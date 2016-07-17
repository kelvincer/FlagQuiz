package com.home.flagquizmvp.entitites;

import java.sql.Blob;
import java.util.List;

/**
 * Created by Kelvin on 5/07/2016.
 */
public class Flag{

    private long id;

    private String flagCode;

    private Blob image;

    private String sourceUrl;

    private List<String> countries;

    private String flagName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlagCode() {
        return flagCode;
    }

    public void setFlagCode(String flagCode) {
        this.flagCode = flagCode;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }
}
