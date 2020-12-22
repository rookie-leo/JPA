package modelo.muitospramuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private	double nota;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
		name = "atores_filmes", //Essa notação realiza a junção entre as duas tabelas
		joinColumns = @JoinColumn(name = "filme_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "ator_id", referencedColumnName = "id")
	)//Definindo de forma detalhada o que será passado para o  BD
	
	private List<Ator> atores;
	
//	Constructors
	public Filme() {}

	public Filme(String nome, double nota){
		super();
		this.nome = nome;
		this.nota = nota;
	}

//	Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Ator> getAtores() {
		if(atores == null) {//Garante que a lista de atores não estaje nula
			atores = new ArrayList<Ator>();
		}
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}
		
	public double getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	//	Methods
	public void adicionarAtor(Ator ator) {
		/*Esse método adiciona um novo ator ao filme e garante o 
		 relacionamento bidirecional sem dados duplicados*/
		if(ator != null && !getAtores().contains(ator)) {
			getAtores().add(ator);
			
			if(!ator.getFilmes().contains(this)) {
				ator.getFilmes().add(this);
			}
		}
	}
}
