package com.linx.desafio.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String rua;
    private String numero;
    private String cidade;
    private String cep;

    @OneToOne
    @JoinColumn(name = "geolocalizacao_id")
    private Geolocalizacao geolocalizacao;


}
