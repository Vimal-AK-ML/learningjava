package com.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class App {
    public static void main(String[] args) {
      Alien telusko = new Alien();
      telusko.setAid(108);
      telusko.setAname("Arun");
      telusko.setColor("Green");
      Configuration  configuration=new Configuration();
      configuration.configure("hibernate.cfg.xml");
      configuration.addAnnotatedClass(Alien.class);
      SessionFactory sf=configuration.buildSessionFactory();  
    
      Session session1 = sf.openSession();
        session1.beginTransaction();
        Alien a1=session1.get(Alien.class,108);
        System.out.println(a1);
        // Query query = session1.createQuery("SELECT COUNT(s.aid) FROM Alien s");
        // Long count = (Long) query.uniqueResult();
        // System.out.println("counted"+count);
        // session1.getTransaction().commit();
        // session1.detach(telusko);
        // telusko.setColor("Pink");
        session1.close();
    }
}
  