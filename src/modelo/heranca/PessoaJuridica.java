package modelo.heranca;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa{

	private String nome;
	
	@Column(name = "salario_pj")
	private double salario;

	public PessoaJuridica() {}
	
	public PessoaJuridica(String nome, double salario) {
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
