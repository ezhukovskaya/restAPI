package pageObjects.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Adresses{
    @JsonProperty("street")
    private String street;
    @JsonProperty("suite")
    private String suite;
    @JsonProperty("city")
    private String city;
    @JsonProperty("zipcode")
    private String zipcode;
    @JsonProperty("geo")
    private Geos geos;

    public Adresses(String street, String suite, String city, String zipcode, Geos geos) {
        this.city=city;
        this.geos=geos;
        this.street=street;
        this.suite=suite;
        this.zipcode=zipcode;
    }
}
