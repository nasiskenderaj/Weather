package WeatherClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sys {
    private long sunrise;
    private  int type;
    private  long id;
    private long sunset;
    private String country;
}
