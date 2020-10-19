package com.linx.desafio.domain;

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
    private String street;
    private String suite;
    private String city;
    private String zipcode;

    @OneToOne
    @JoinColumn(name = "geolocalizacao_id")
    private Geolocalizacao geo;

    /*Construtores*/
    public Endereco() {
    }

    public Endereco(Integer id, String street, String suite, String city, String zipcode, Geolocalizacao geo) {
        super();
        this.id = id;
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geolocalizacao getGeo() {
        return geo;
    }

    public void setGeo(Geolocalizacao geo) {
        this.geo = geo;
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
