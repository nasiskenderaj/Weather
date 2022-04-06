package Functionalities;

import Entities.CityWeather;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

public interface FindCity {
    public CityWeather findcity(String cityname,long date,String inicialet) throws IOException;
}
