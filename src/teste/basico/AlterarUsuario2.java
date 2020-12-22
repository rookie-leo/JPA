package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario2 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario user = em.find(Usuario.class, 7L);
		user.setEmail("vora_alterada@paladins.com");
		
		/*Mesmo sem o merge, o update será realizado, pois o objeto está em estado gerenciado*/
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
