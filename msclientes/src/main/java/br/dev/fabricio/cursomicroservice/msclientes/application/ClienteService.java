package br.dev.fabricio.cursomicroservice.msclientes.application;

import br.dev.fabricio.cursomicroservice.msclientes.domain.Cliente;
import br.dev.fabricio.cursomicroservice.msclientes.infra.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteService {

  private final ClienteRepository repository;


  public ClienteService(ClienteRepository repository) {
    this.repository = repository;
  }

  @Transactional
  public Cliente save(Cliente cliente) {
    return repository.save(cliente);
  }

  public Optional<Cliente> getByCpf(String cpf) {
    return repository.findByCpf(cpf);
  }


}
