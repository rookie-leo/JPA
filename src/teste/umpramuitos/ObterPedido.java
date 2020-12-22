package teste.umpramuitos;

import infra.DAO;
import modelo.umpramuitos.ItemPedido;
import modelo.umpramuitos.Pedido;

public class ObterPedido {

	public static void main(String args[]) {
		
		DAO<Pedido> dao = new DAO<>(Pedido.class);
		
		Pedido pedido = dao.obterPorID(1L);
		/*Se o atributo itens na classe Pedido, ter fetch = FetchType.EAGER, faz com que
		 a consulta ao BD seja feita de forma rápida, ou seja, a consulta será realizada 
		 mesmo com o EntityManager da classe DAO estando fechado, isso não seria possível
		 se o fetch fosse FetchType.LAZY*/
		
		for (ItemPedido item: pedido.getItens()) {
			System.out.println(item.getQuantidade());
			System.out.println(item.getProduto().getNome());
		}
		
		dao.finalizar();
	}
}
