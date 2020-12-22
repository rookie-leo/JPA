package modelo.composicao;

import javax.persistence.Embeddable;

@Embeddable
/*Indica que os dados tratados nessa classe serão compartilhados com outras tabelas 
 q tenham em comum, colunas com o mesmo nome*/
public class Endereco {

	private String logradouro;
	private String complemento;
	
//	Getters and Setters
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
