package io.github.luaprogrammer.lojavirtual.entities;

import io.github.luaprogrammer.lojavirtual.enums.TipoCadastro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoCadastro tipoCadastro;

    private String email;

    private String senha;

    @OneToOne
    private Pessoa pessoa;

}
