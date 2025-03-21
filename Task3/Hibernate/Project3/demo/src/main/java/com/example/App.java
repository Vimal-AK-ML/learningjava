package com.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Laptop laptop = new Laptop();
    	laptop.setLid(102);
    	laptop.setLname("Lenovo");
    	
        Student s = new Student();
        s.setName("Vimal");
        s.setRollno(2);
        s.setMarks(93);
        s.getLaptop().add(laptop);
        
    	laptop.getStudent().add(s);
        
        Configuration  configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Laptop.class);
        SessionFactory sf=configuration.buildSessionFactory();  
        Session session = sf.openSession();
      
        
        session.beginTransaction();
        
        session.persist(laptop);
        session.persist(s);
        
        session.getTransaction().commit();
    }
}
