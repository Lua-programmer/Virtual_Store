package io.github.luaprogrammer.lojavirtual.repositories;

import io.github.luaprogrammer.lojavirtual.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
