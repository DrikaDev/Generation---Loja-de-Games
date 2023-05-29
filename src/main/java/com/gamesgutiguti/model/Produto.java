package com.gamesgutiguti.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Campo de preenchimento obrigatório.")
	@Size(min = 2, max = 50, message = "No mínimo 2 e no máximo 50 caracteres.")
	private String nome;
	
	@Positive(message = "Campo não pode ter valor negativo.")
	private Double preco;
	
	@NotBlank(message = "Campo de preenchimento obrigatório.")
	@Size(min = 2, max = 255, message = "No mínimo 2 e no máximo 255 caracteres")
	private String descricao;
	
	@Positive(message = "Campo não pode ter valor negativo.")
	private Integer quantidade;
	
	//campo que irá interligar as duas tabelas: produto e usuario
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;
	
	//campo que irá interligar as duas tabelas: produto e categoria
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;
	
	//criar os getters & setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	//agora pode rodar no Spring Boot App
	//e ver no MySQL
}
