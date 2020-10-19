package com.linx.desafio.domain;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String frase;
    private String bs;
}
