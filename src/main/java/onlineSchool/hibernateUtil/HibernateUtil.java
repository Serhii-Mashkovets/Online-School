package onlineSchool.hibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory =
            new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private static Configuration configuration;

    private static SessionFactory buildSessionFactory() {
        try {
            configuration = new Configuration().configure();
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

            return configuration.buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
