package lab.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import lab.model.Chemical;

public class Main extends Application {
    
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = (VBox) FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Laboratorija");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// DatabaseManager dbManager = DatabaseManager.getInstance();
		// Configure the session factory
		try {
			Configuration configuration = new Configuration();
		    configuration.configure("/META-INF/hibernate.cfg.xml");
		    
		    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();
		    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Chemical chemical = new Chemical();
            chemical.setLatin_name("carbon acid");
            chemical.setName("karbonatna kiselina");
            Chemical chemical2 = new Chemical();
            chemical2.setName("azotna kiselina");
            chemical2.setLatin_name("nitro acid");
            Chemical chemical3 = new Chemical();
            chemical3.setLatin_name("www");
            chemical3.setName("qqq");
            //chemical.setId(1L);
            //session.save(chemical);
            //session.save(chemical2);
            session.save(chemical3);
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch(HibernateException e) {
            e.printStackTrace();
        }
		launch(args);
	}
}
