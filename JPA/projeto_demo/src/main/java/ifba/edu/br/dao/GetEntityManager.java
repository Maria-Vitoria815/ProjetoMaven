package ifba.edu.br.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GetEntityManager {
	
	private static final String JPA = "projeto_jpa";
	private static EntityManagerFactory emf;
	
	public static EntityManager getConnectionJpa() {
		
		emf = Persistence.createEntityManagerFactory(JPA);
		EntityManager em = emf.createEntityManager();
		
		return em;
		
	}
	

}