package com.santamaria.aldo.pruebatecnicaitacademy.repositories;

import com.santamaria.aldo.pruebatecnicaitacademy.models.Skin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ISkinRepository  extends JpaRepository<Skin, Long> {

    List<Skin> findAll();

    Skin save(Skin skin);

    void deleteById(Long id);

    Optional<Skin> findById(Long id);

}
