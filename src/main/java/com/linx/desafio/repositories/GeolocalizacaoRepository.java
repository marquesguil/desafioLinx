package com.linx.desafio.repositories;

import com.linx.desafio.domain.Geolocalizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeolocalizacaoRepository extends JpaRepository<Geolocalizacao, Integer> {
}
