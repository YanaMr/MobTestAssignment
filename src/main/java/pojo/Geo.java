package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class Geo {

    @JsonProperty("lng")
    private String lng;
    @JsonProperty("lat")
    private String lat;

//    public String getLng ()
//    {
//        return lng;
//    }
//
//    public void setLng (String lng)
//    {
//        this.lng = lng;
//    }
//
//    public String getLat ()
//    {
//        return lat;
//    }
//
//    public void setLat (String lat)
//    {
//        this.lat = lat;
//    }
//
//    @Override
//    public String toString()
//    {
//        return "ClassPojo [lng = "+lng+", lat = "+lat+"]";
//    }
}