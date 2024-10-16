package com.example.ProjetoSenai.Atividades2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();

    @PostMapping("/adicionar")
    public ResponseEntity<Usuario> adicionarUsuario(@RequestBody Usuario usuario){
        usuario.setId(usuarios.size()+ 1);
        usuarios.add(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);

    }

    @GetMapping("/lista")
    public ResponseEntity<List<Usuario>> ListarUsuario() {
        return ResponseEntity.ok(usuarios);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable int id, @RequestBody Usuario novosdados) {
        Usuario usuarioexiste = buscarUsuarioporId(id);

        if(usuarioexiste != null) {
            if(novosdados.getNome() != null) {
                usuarioexiste.setNome(novosdados.getNome());
            }
            if(novosdados.getEmail() != null){
                usuarioexiste.setEmail(novosdados.getEmail());
            }

            return ResponseEntity.ok(usuarioexiste);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable int id) {
        Usuario usuarioExistente = buscarUsuarioporId(id);

        if(usuarioExistente != null) {
            usuarios.remove(usuarioExistente);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    private Usuario buscarUsuarioporId(int id) {
        return usuarios.stream().filter(usuario -> usuario.getId() == id).findFirst().orElse(null);
    }
}
