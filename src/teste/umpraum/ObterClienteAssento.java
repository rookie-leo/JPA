package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class ObterClienteAssento {

	public static void main(String[] args) {
		/*Testando relacionamento bidirecional*/
		DAO<Cliente> daoCliente = new DAO<>(Cliente.class);
		
		Cliente cliente = daoCliente.obterPorID(3L);
		System.out.println(cliente.getAssento().getNome());
		daoCliente.finalizar();

		
		DAO<Assento> daoAssento = new DAO<>(Assento.class);
		
		Assento assento = daoAssento.obterPorID(1L);
		System.out.println(assento.getCliente().getNome());
		daoAssento.finalizar();
	}
}
