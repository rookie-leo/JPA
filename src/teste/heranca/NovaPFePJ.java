package teste.heranca;

import infra.DAO;
import modelo.heranca.PessoaFisica;
import modelo.heranca.PessoaJuridica;

public class NovaPFePJ {

	public static void main(String args[]) {
		
		PessoaFisica pf = new PessoaFisica("João", 1048.99);
		PessoaJuridica pj = new PessoaJuridica("Maria", 1030.15);
		
		DAO<PessoaFisica> daoPF = new DAO<>();
		daoPF.incluirAtomico(pf);
		daoPF.finalizar();
		
		DAO<PessoaJuridica> daoPJ = new DAO<>();
		daoPJ.incluirAtomico(pj);
		daoPJ.finalizar();
	}
}
