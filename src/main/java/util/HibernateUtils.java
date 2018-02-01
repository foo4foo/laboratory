package util;

import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sessionFactory = null;
    private static Logger logger = Logger.getLogger(HibernateUtils.class.getName());

    public static void createSessionFactory() {

        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());

        try {
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Exception exe) {
            exe.printStackTrace();
        }

        logger.info("Hibernate configured");
    }

    public static SessionFactory getSessionFactory() {

        return sessionFactory;
    }

    public static void shutdown() {

        if (sessionFactory != null)
            getSessionFactory().close();
    }
}