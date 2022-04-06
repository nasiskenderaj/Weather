package Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class City {
    @Id
    private  String name;
    private float lon;
    private float lat;
    private String country;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "city")
    private List<CityWeather> cityWeather=new ArrayList<>();
}
