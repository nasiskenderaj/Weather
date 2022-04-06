package Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class CityWeather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cityweather_id;
    private String weather;
    private float wind_speed;
    private float temp_min;
    private float temp_max;
    private int humidity;
    private float pressure;
    private long dt;
    @ManyToOne
    @JoinColumn(name="city_name")
    private City city;

    @Override
    public String toString() {
        return "CityWeather{" +
                "cityweather_id=" + cityweather_id +
                ", weather='" + weather + '\'' +
                ", wind_speed=" + wind_speed +
                ", temp_min=" + temp_min +
                ", temp_max=" + temp_max +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", dt=" + dt +
                '}';
    }
}
