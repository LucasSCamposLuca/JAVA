package com.example.ProjetoSenai.Atividades3;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>();

    @PostMapping("/adicionar")
    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto){
        produto.setId(produtos.size() + 1);
        produtos.add(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Produto>> ListarProduto() {
        return ResponseEntity.ok(produtos);
    }
}
