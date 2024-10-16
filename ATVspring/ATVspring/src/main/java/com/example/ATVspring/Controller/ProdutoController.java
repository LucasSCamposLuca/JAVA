package com.example.ATVspring.Controller;

import com.example.ATVspring.Atividade.Atividade;
import com.example.ATVspring.Model.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    private List<Atividade> produtos = new ArrayList<>();

    @GetMapping("/listar")
    private  List<Atividade> Listarproduto(){
        List<Atividade>  produtosBanco = produtoRepository.findAll();
        List<Atividade> todosprodutos = new ArrayList<>();
        todosprodutos.addAll(produtosBanco);
        return todosprodutos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atividade> buscarProdutoporId(@PathVariable Long id){
        Optional<Atividade> produto = produtoRepository.findById(id);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/adicionar")
    public Atividade adicionarProduto (@RequestBody Atividade produto) {
        return produtoRepository.save(produto);
    }

    @PostMapping("/{id}")
    public Atividade criarProduto (@RequestBody Atividade produto) {
        return produtoRepository.save(produto);
    }








}
