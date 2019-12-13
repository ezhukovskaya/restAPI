package pageObjects.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Companies{
    @JsonProperty("name")
    private String name;
    @JsonProperty("catchPhrase")
    private String catchPhrase;
    @JsonProperty("bs")
    private String bs;

    public Companies(String name, String catchPhrase, String bs){
        this.bs=bs;
        this.catchPhrase=catchPhrase;
        this.name=name;
    }
}
