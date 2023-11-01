package br.com.petsec.app;

import java.util.Date;

import br.com.petsec.DAO.ClienteDAO;
import br.com.petsec.model.Cliente;

public class MAIN {

	public static void main(String[] args) {
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		
		cliente.setIDCliente(1);
		cliente.setNomeCliente("RB");
		cliente.setSexoCliente("MALE");
		cliente.setDataNascimento(new Date());
		
		clienteDAO.save(cliente);
		
		Cliente cliente1 = new Cliente();
		
		cliente1.setIDCliente(1);
		cliente1.setDataNascimento(new Date());
		cliente1.setNomeCliente("Gabriel");
		cliente1.setSexoCliente("FEMALE");
		clienteDAO.updateCliente(cliente1);
		
		clienteDAO.removeById(1);
		
		for(Cliente c: clienteDAO.getCliente()) {
			System.out.println("NOME:"+ c.getNomeCliente());
		}
	}
}
