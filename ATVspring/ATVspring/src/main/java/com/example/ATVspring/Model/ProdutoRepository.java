package com.example.ATVspring.Model;

import com.example.ATVspring.Atividade.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Atividade, Long> {
}
