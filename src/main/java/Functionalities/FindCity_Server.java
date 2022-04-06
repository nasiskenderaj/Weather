package Functionalities;

import Entities.City;
import Entities.CityWeather;
import WeatherClasses.WeatherApp;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class FindCity_Server implements FindCity {
    @Override
    public CityWeather findcity(String cityname,long date,String inicialet) throws IOException {
        String url="https://api.openweathermap.org/data/2.5/weather?q="+cityname+","+inicialet+"&APPID=ffc0e8178a1559181248dd1842f57b7c";
        URL urlobject =new URL(url);
        HttpURLConnection connection= (HttpURLConnection) urlobject.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader bufferedReader = null;
        try {
             bufferedReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("wrong city or country,try again");
        }
        String inputline;
        StringBuffer stringBuffer= new StringBuffer();
        while ((inputline=bufferedReader.readLine())!=null){
            stringBuffer.append(inputline);
        }
        String str=stringBuffer.toString().replaceAll("[\"]","'");
        bufferedReader.close();
        Gson gson=new Gson();
        WeatherApp weatherApp=gson.fromJson(str,WeatherApp.class);
        CityWeather cityWeather=new CityWeather();
        cityWeather.setHumidity(weatherApp.getMain().getHumidity());
        cityWeather.setPressure(weatherApp.getMain().getPressure());
        cityWeather.setTemp_min(weatherApp.getMain().getTemp_min());
        cityWeather.setTemp_max(weatherApp.getMain().getTemp_max());
        cityWeather.setWind_speed(weatherApp.getWind().getSpeed());
        cityWeather.setWeather(weatherApp.getWeather()[0].getMain());
        cityWeather.setDt(weatherApp.getDt());
        City city=new City();
        city.setName(cityname);
        city.setLon(weatherApp.getCoord().getLon());
        city.setLat(weatherApp.getCoord().getLat());
        city.setCountry(weatherApp.getSys().getCountry());
        cityWeather.setCity(city);
        return cityWeather;
    }
}
