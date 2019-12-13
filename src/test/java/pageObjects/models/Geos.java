package pageObjects.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Geos {
    @JsonProperty("lat")
    private String lat;
    @JsonProperty("lng")
    private String lng;

    public Geos(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

}
