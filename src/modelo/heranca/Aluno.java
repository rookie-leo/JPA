package modelo.heranca;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)//Herança onde cada classe tem sua tabela(não precisa do @Discriminator)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//Cria uma unica tabela para as duas classes
@Inheritance(strategy = InheritanceType.JOINED)//Cria duas tabelas com os dados respectivos de cada classe
@DiscriminatorColumn(name = "tipo", 
	length = 2, discriminatorType = DiscriminatorType.STRING)//É utilizado par o marcar o Single_Table
@DiscriminatorValue("AL")//Adiciona na coluna 'tipo' o valro AL
public class Aluno {

	@Id
	private Long matricula;
	
	private String nome;
	
	public Aluno() {}

	public Aluno(Long matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
