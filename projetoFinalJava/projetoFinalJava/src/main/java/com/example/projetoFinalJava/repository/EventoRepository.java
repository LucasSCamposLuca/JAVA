package com.example.projetoFinalJava.repository;

import com.example.projetoFinalJava.models.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<Evento, String> {
    Evento findByCodigo(long codigo);
}
