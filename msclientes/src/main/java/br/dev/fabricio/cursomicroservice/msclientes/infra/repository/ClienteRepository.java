package br.dev.fabricio.cursomicroservice.msclientes.infra.repository;

import br.dev.fabricio.cursomicroservice.msclientes.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
