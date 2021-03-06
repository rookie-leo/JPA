package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class ObterUsuarios {

	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select u from Usuario u";
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		query.setMaxResults(5);//limita o n�mero de resultados gerados pela consulta psql
		
		List<Usuario> usuarios = query.getResultList();
		
		for (Usuario user: usuarios) {
			System.out.println("ID: " + user.getId()
			+ " - Nome: " + user.getNome()
			+ " - E-mail: " + user.getEmail());
		}
		
		em.close();
		emf.close();
	}
	
}
