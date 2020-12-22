package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {//Torna a classe generica
	
	private static EntityManagerFactory emf;/*atributos estaticos podem ser iniciados AQUI 
	ou em um bloco static*/
	private EntityManager em;
	private Class<E> classe;
	
	static {
		/*O bloco static é executado uma unica vez quando o java carrega a classe*/
		try {
			emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		}catch (Exception e) {
			
		}
	}
	
//	Construtores
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
//	Métodos
	public DAO<E> abrirTransacao(){
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> fecharTransacao(){
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> incluir(E entidade){
		em.persist(entidade);
		return this;
	}
	
	public DAO<E> incluirAtomico(E entidade){
		/*Atomico indica que o método fará todas as transações de uma unica vez*/
		return this.abrirTransacao().incluir(entidade).fecharTransacao();
	}
	
	public List<E> obterTodos(){
		/*Esse método tem como valor padrão o limite de 10 entidades para busca e 
		 * com deslocamento 0*/
		return this.obterTodos(10, 0);
	}
	
	public List<E> obterTodos(int limit, int offset){
		/*Esse método busca e retorna um valor especifico de entidades 
		 apartir do valor especificado de deslocamento*/
		if(classe == null) {
			throw new UnsupportedOperationException("A classe está nula/não foi inicializada");
		}
		
		String jpql = "select e from " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(limit);
		query.setFirstResult(offset);
		return query.getResultList();
	}
	
	public E obterPorID(Object id) {
		return em.find(classe, id);
	}
	
	public List<E> consultar(String nomeConsulta, Object... params){
		/*Esse método irá receber uma consulta definida no arquivo consultas.xml, com um array de parametros,
		 criar a lista de consulta com o tipo da classe e retornar o valor especificado*/
		TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);
		
		for (int i = 0; i < params.length; i += 2) {
			query.setParameter(params[i].toString(), params[i +1]);
		}
		
		return query.getResultList();
	}
	
	public E consultarUm(String nomeConsulta, Object... params) {
		/*Esse método irá fazer uma consulta e retornar apenas um unico elemento da query*/
		List<E> lista = consultar(nomeConsulta, params);
		return lista.isEmpty() ? null : lista.get(0);
	}
	
	public void finalizar() {
		/*Esse metodo fecha o EntityManager*/
		em.close();
	}
}
