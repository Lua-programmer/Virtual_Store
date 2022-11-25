package io.github.luaprogrammer.lojavirtual.controllers;


import io.github.luaprogrammer.lojavirtual.entities.Pessoa;
import io.github.luaprogrammer.lojavirtual.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity create(@RequestBody Pessoa pessoa) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(pessoaService.save(pessoa).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> getPessoas() {
        return ResponseEntity.ok(pessoaService.findAllPessoas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        pessoa.setId(id);
        Pessoa pessoaSalva = pessoaService.updatePessoa(pessoa);
        return ResponseEntity.ok(pessoaSalva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable Long id) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
