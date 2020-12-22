package teste.heranca;

import infra.DAO;
import modelo.heranca.Aluno;
import modelo.heranca.AlunoBolsista;

public class NovoAluno {

	public static void main(String[] args) {
		
		DAO<Aluno> dao = new DAO<>();
		
		Aluno al = new Aluno(123L, "Bernardo");
		AlunoBolsista ab = new AlunoBolsista(456L, "Melissa", 1000);
		
		dao.incluirAtomico(al);
		dao.incluirAtomico(ab);
		dao.finalizar();
	}
}
