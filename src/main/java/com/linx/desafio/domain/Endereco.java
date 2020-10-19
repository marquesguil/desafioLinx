package com.linx.desafio.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    /*Atributos*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String rua;
    private String numero;
    private String cidade;
    private String cep;

    @OneToOne
    @JoinColumn(name = "geolocalizacao_id")
    private Geolocalizacao geolocalizacao;

    /*Construtores*/
    public Endereco() {
    }

    public Endereco(Integer id, String rua, String numero, String cidade, String cep, Geolocalizacao geolocalizacao) {
        super();
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.cep = cep;
        this.geolocalizacao = geolocalizacao;
    }

    /*Getters e Setters*/
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Geolocalizacao getGeolocalizacao() {
        return geolocalizacao;
    }

    public void setGeolocalizacao(Geolocalizacao geolocalizacao) {
        this.geolocalizacao = geolocalizacao;
    }

    /*Hash e Equals*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
