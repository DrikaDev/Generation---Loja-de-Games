package com.gamesgutiguti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gamesgutiguti.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	//metodos de consultas personalizados que permitem criar consultas especificas 
	//com qualquer atributo da classe associada a classe repository
	List<Produto> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

}
