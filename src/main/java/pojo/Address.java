package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class Address {

    @JsonProperty("zipcode")
    private String zipcode;
    @JsonProperty("geo")
    private Geo geo;
    @JsonProperty("suite")
    private String suite;
    @JsonProperty("city")
    private String city;
    @JsonProperty("street")
    private String street;

//    public String getZipcode ()
//    {
//        return zipcode;
//    }
//
//    public void setZipcode (String zipcode)
//    {
//        this.zipcode = zipcode;
//    }
//
//    public Geo getGeo ()
//    {
//        return geo;
//    }
//
//    public void setGeo (Geo geo)
//    {
//        this.geo = geo;
//    }
//
//    public String getSuite ()
//    {
//        return suite;
//    }
//
//    public void setSuite (String suite)
//    {
//        this.suite = suite;
//    }
//
//    public String getCity ()
//    {
//        return city;
//    }
//
//    public void setCity (String city)
//    {
//        this.city = city;
//    }
//
//    public String getStreet ()
//    {
//        return street;
//    }
//
//    public void setStreet (String street)
//    {
//        this.street = street;
//    }
//
//    @Override
//    public String toString()
//    {
//        return "ClassPojo [zipcode = "+zipcode+", geo = "+geo+", suite = "+suite+", city = "+city+", street = "+street+"]";
//    }
}
