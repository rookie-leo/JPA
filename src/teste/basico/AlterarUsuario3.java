package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario3 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario user = em.find(Usuario.class, 7L);
		user.setEmail("vora03@paladins.com");
		
		/*detach coloca o objeto em estado n�o gerenciado, para que n�o atualize a cada altera��o 
		 feita no codigo*/
		em.detach(user);
		
		
		/*merge torna o objeto gerenciavel e atualiza a altera��o feita*/
		em.merge(user);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
