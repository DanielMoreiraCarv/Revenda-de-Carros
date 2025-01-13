package Treinamento.RevendaAutomobilistica.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Treinamento.RevendaAutomobilistica.Class.Cliente;
import Treinamento.RevendaAutomobilistica.Repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> getAllClientes(){
		return clienteRepository.findAll();
	}
	
	@Transactional
	public List<Cliente> getClienteByNome(String nome){
		return clienteRepository.findClienteByNome(nome);
	}
	
	public Cliente getClienteByCpf(String cpf) {
		return clienteRepository.findClienteByCpf(cpf);
	}
	public Cliente getClienteById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	public void deleteClienteById(Long id) {
		clienteRepository.deleteById(id);
	}
	
	public void deleteCliente(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
	public void deleteClienteByCpf(String cpf) {
		clienteRepository.deleteClienteByCpf(cpf);
	}
	
	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void atualizarNome(Long id, String nome) {
		clienteRepository.atualizarNome(id, nome);
	}
}
