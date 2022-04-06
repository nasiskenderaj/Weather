import Entities.City;
import Entities.CityWeather;
import Functionalities.DisplaAndSaveCity;
import WeatherClasses.WeatherApp;
import com.google.gson.Gson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("jepni emrin e qytetit");
        String city_name=scanner.next();
        System.out.println("jepni inicialet e shtetit");
        String inicialet= scanner.next();
        System.out.println("jepni daten");
        long date=scanner.nextLong();
        DisplaAndSaveCity displaAndSaveCity=new DisplaAndSaveCity();
        displaAndSaveCity.display_and_save_city(city_name,date,inicialet);
//        SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CityWeather.class).addAnnotatedClass(City.class).buildSessionFactory();
//        Session session=sessionFactory.openSession();
//        Transaction transaction=session.beginTransaction();
//        ArrayList<CityWeather> cityWeather= (ArrayList<CityWeather>) session.createQuery("from CityWeather where city_name='tirana' and dt=1649260567").getResultList();
//        System.out.println(cityWeather);
//        transaction.commit();

    }
}
