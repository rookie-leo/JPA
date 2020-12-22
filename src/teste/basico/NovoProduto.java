package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {

	public static void main(String[] args) {
		
		Produto prod = new Produto("Tablet", 750.00);
		
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
//		dao.abrirTransacao().incluir(prod).fecharTransacao().finalizar();
		dao.incluirAtomico(prod).finalizar();
		
		System.out.println("ID do produto: " + prod.getId() + "\nNome: " + prod.getNome());
	}
}
