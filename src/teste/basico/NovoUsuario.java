package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {

	public static void main(String[] args) {
		
		/*Cria uma fabrica de conexões para um BD especifico*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario novoUsuario = new Usuario("Teste", "teste@teste.com");
//		novoUsuario.setId(1L);//Gera um Id
		
		//		Persiste o obj no banco
		em.getTransaction().begin();
		em.persist(novoUsuario);
		em.getTransaction().commit();
				
		em.close();
		emf.close();
	}
}
