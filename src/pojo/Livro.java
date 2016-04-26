package pojo;

/**
 * @author André Marques Guedes
 *
 */

import java.util.ArrayList;

public class Livro {
	private int isbn;
	private String titulo;
	private String editora;
	private int qtd_livro;
	private ArrayList<Autor> autores;
	private ArrayList<Genero> generos;
	
	public Livro(){
		
	}
	
	public Livro(int isbn, String titulo, String editora, int qtd_livro) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.editora = editora;
		this.qtd_livro = qtd_livro;
	}
	
	public Livro(int isbn, String titulo, String editora, int qtd_livro, ArrayList<Autor> autores,
			ArrayList<Genero> generos) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.editora = editora;
		this.qtd_livro = qtd_livro;
		this.autores = autores;
		this.generos = generos;
	}
	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getQtd_livro() {
		return qtd_livro;
	}
	public void setQtd_livro(int qtd_livro) {
		this.qtd_livro = qtd_livro;
	}
	public ArrayList<Autor> getAutores() {
		return autores;
	}
	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}
	public ArrayList<Genero> getGeneros() {
		return generos;
	}
	public void setGeneros(ArrayList<Genero> generos) {
		this.generos = generos;
	}

	
	
}
