package Functionalities;

import Entities.City;
import Entities.CityWeather;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class FindCity_Database implements FindCity{
    @Override
    @Transactional
    public CityWeather findcity(String cityname,long date,String inicialet) {
        SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CityWeather.class).addAnnotatedClass(City.class).buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
//        City city = (City) session.createQuery("from City where name=:cityname").setParameter("cityname",cityname).getResultList().get(0);
////        sessionQuery.setParameter("cityname",cityname);
////        City city= (City) sessionQuery.list().get(0);
//        int id=city.getCity_id();
        ArrayList<CityWeather> cityWeather= (ArrayList<CityWeather>) session.createQuery("from CityWeather where city_name=: id and dt=: date").setParameter("id",cityname).setParameter("date",date).getResultList();
        transaction.commit();
        session.close();
        if (!cityWeather.isEmpty())
            return cityWeather.get(0);
        else
            return null;
    }
}
