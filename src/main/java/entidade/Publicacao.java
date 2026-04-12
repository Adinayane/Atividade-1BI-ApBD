package entidade;

import jakarta.persistence.*;

@Entity
public class Publicacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoPub;
	private String titulo;
	private int ano;
	private String autor;
	private String tipo;
	
	public Publicacao() {
	}

	public Publicacao(String titulo, int ano, String autor, String tipo) {
		super();
		this.titulo = titulo;
		this.ano = ano;
		this.autor = autor;
		this.tipo = tipo;
	}
	
	public int getCodigoPub() {
		return codigoPub;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
