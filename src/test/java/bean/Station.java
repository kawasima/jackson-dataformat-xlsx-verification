package bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.Date;

@JsonPropertyOrder({"駅名", "乗降客数", "開業日"})
public class Station implements Serializable {
    private String name;
    private int numOfPassengers;
    private Date createdOn;

    public Station(String name, int numOfPassengers, Date createdOn) {
        this.name = name;
        this.numOfPassengers = numOfPassengers;
        this.createdOn = createdOn;
    }

    @JsonProperty("駅名")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("乗降客数")
    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    @JsonProperty("開業日")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "GGGGy年M月d日", locale = "ja-JP-JP_#u-ca-japanese")
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
