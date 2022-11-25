package io.github.luaprogrammer.lojavirtual.services;


import io.github.luaprogrammer.lojavirtual.entities.Pessoa;
import io.github.luaprogrammer.lojavirtual.repositories.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoaService implements IPessoaService {

    private final PessoaRepository pessoaRepository;

    @Override
    public List<Pessoa> findAllPessoas() {
        return pessoaRepository.findAll();
    }

    @Override
    public Optional<Pessoa> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public void delete(Long id) {
        Optional<Pessoa> pessoaOp = pessoaRepository.findById(id);
        if (!pessoaOp.isPresent()) {
            throw new Error("Não existe pessoa com esse id");
        }
        pessoaRepository.delete(pessoaOp.get());
    }

    @Override
    public Pessoa updatePessoa(Pessoa pessoa) {
        if (pessoaRepository.existsById(pessoa.getId())) {
            return pessoaRepository.save(pessoa);
        } else {
            throw new Error("Não existe pessoa com esse id");
        }
    }
}
