package Functionalities;

import Entities.City;
import Entities.CityWeather;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.List;

public class DisplaAndSaveCity {
    public void display_and_save_city(String name,long date,String inicialet) throws IOException {
        FindCity_Database findCity_database = new FindCity_Database();
        CityWeather cityWeather = findCity_database.findcity(name,date,inicialet);
        if (cityWeather==null){
            System.out.println("no data for this city in this date in database");
            FindCity_Server findCity_server=new FindCity_Server();
            SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(City.class).addAnnotatedClass(CityWeather.class).buildSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            CityWeather cityWeather1=findCity_server.findcity(name,date,inicialet);
            City city=cityWeather1.getCity();
            List<String> nameList=session.createQuery("select name from City").getResultList();
            if (!nameList.contains(name)) {
                session.save(city);
            }
            session.save(cityWeather1);
            transaction.commit();
            System.out.println(cityWeather1);

        }
        else {
            System.out.println(cityWeather);
        }
    }
}
