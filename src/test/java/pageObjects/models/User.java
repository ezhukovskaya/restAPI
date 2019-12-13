package pageObjects.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    @JsonProperty("address")
    private Adresses adresses;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("website")
    private String website;
    @JsonProperty("company")
    private Companies companies;

    public User(int id, String name, String username, String email, Adresses adresses, String phone, String website, Companies companies) {
        this.id=id;
        this.adresses=adresses;
        this.companies=companies;
        this.email=email;
        this.name=name;
        this.phone=phone;
        this.username=username;
        this.website=website;
    }
}
