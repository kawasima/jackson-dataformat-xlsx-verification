package bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonPropertyOrder({"prefecture", "city"})
public class Address implements Serializable {
    private String prefecture;
    private String city;

    public Address(String prefecture, String city) {
        this.prefecture = prefecture;
        this.city = city;
    }

    @JsonProperty("prefecture")
    public String getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
