package com.example.projetoFinalJava.repository;

import com.example.projetoFinalJava.models.Convidado;
import com.example.projetoFinalJava.models.Evento;
import org.springframework.data.repository.CrudRepository;

public interface ConvidadoRepository extends CrudRepository<Convidado, String> {
    Iterable<Convidado> findByEvento (Evento evento);
    Convidado findByRg(String rg);
}
