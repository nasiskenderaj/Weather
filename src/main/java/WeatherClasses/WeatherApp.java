package WeatherClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherApp {
    Coordinates coord;
    private String base;
    private float visibility;
    private long id;
    private float timezone;
    private float cod;
    private String name;
    private long dt;

    Clouds clouds;
    mainclass main;
    Sys sys;
    Wind wind;
    private Weather[] weather;

}
