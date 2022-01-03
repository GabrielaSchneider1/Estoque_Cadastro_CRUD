package com.fundatec.lpi.estoque.dominio;

public class Item {
	private int id;
	private String nome;
	private float preco;
	
	private String novoNome;

	public Item(String nome, float preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public Item(int id, String nome, float preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Item(String novoNome) {
		super();
		this.novoNome = novoNome;
	}

	public String getNovoNome() {
		return novoNome;
	}

	public void setNovoNome(String novoNome) {
		this.novoNome = novoNome;
	}

}
