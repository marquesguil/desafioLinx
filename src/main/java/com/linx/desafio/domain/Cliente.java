package com.linx.desafio.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String username;
    private String email;
    private String telefone;
    private String site;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

}
