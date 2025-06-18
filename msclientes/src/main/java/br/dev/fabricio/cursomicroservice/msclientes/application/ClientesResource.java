package br.dev.fabricio.cursomicroservice.msclientes.application;

import br.dev.fabricio.cursomicroservice.msclientes.application.representation.ClienteSaveRequest;
import br.dev.fabricio.cursomicroservice.msclientes.domain.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesResource {

  private final ClienteService service;

  public ClientesResource(ClienteService service) {
    this.service = service;
  }

  @GetMapping
  public String status() {
    return "Ok";
  }

  @PostMapping
  public ResponseEntity save(@RequestBody ClienteSaveRequest request) {
    Cliente cliente = request.toModel();


    service.save(cliente);
    URI headerLocation = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .query("cpf={cpf}")
            .buildAndExpand(cliente.getCpf())
            .toUri();
    return ResponseEntity.created(headerLocation).build();
  }

  @GetMapping
  public ResponseEntity<Cliente> findByCpf(@RequestParam String cpf) {

    Optional<Cliente> optionalCliente = service.getByCpf(cpf);
    if (optionalCliente.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(optionalCliente.get());
  }

}
