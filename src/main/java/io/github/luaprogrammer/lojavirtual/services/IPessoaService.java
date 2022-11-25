package io.github.luaprogrammer.lojavirtual.services;

import io.github.luaprogrammer.lojavirtual.entities.Pessoa;

import java.util.List;
import java.util.Optional;

public interface IPessoaService {

    List<Pessoa> findAllPessoas();

    Optional<Pessoa> findById(Long id);

    Pessoa save(Pessoa pessoa);

    void delete(Long id);

    Pessoa updatePessoa(Pessoa pessoa);
}
