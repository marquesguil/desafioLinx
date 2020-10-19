package com.linx.desafio.domain;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Geolocalizacao implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Double lat;
    private Double lng;
}
