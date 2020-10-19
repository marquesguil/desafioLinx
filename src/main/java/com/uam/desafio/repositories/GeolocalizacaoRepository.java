package com.uam.desafio.repositories;

import com.uam.desafio.domain.Geolocalizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeolocalizacaoRepository extends JpaRepository<Geolocalizacao, Integer> {
}
