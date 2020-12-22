package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario1 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		/*Inicia a transação com o BD*/
		em.getTransaction().begin();
		
		Usuario user = em.find(Usuario.class, 7L);//Encontra o objeto solicitado
		/*Faz a alteração do objeto solicitado*/
		user.setNome("Vora");
		user.setEmail("vora@paladins.com");
		/*Confirma o update*/
		em.merge(user);
		em.getTransaction().commit();
				
		em.close();
		emf.close();
	}
}
