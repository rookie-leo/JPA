package modelo.heranca;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Pessoa{

	private String nome;
	
	@Column(name = "salario_pf")
	private double salario;
	
	public PessoaFisica() {}
	
	public PessoaFisica(String nome, double salario) {
		this.nome = nome;
		this.salario = salario;
	}

//	Getters and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
}
