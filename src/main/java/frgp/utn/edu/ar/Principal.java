package frgp.utn.edu.ar;

import java.util.ArrayList;

import org.hibernate.service.ServiceRegistry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import frgp.utn.edu.ar.entidad.Autor;

public class Principal {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory;
		Configuration configuration = new Configuration();
		configuration.configure();
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();
		
         session.beginTransaction();
    	
    	Autor autor = new Autor();
    	autor.setNombre("Pepe");
    	autor.setApellido("123");
    	autor.setEmail("sdsd");
    	autor.setNacionalidad("Argentino");
    	autor.setId("1");
    	
    	
    	
    	
    	
        session.save(autor);  
    	
    	session.getTransaction().commit();
    	session.close();
		
	}

}
