package com.example.projetoFinalJava.repository;

import com.example.projetoFinalJava.models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {

    Usuario findByLogin(String login);

}
