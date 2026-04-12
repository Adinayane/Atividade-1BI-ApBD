package entidade;

import jakarta.persistence.*;

@Entity
public class Aluno {
	
	@Id
	private int matriculaAluno;
	private String nome;
	
	public Aluno() {
	}

	public Aluno(int matriculaAluno, String nome) {
		super();
		this.matriculaAluno = matriculaAluno;
		this.nome = nome;
	}

	public int getMatriculaAluno() {
		return matriculaAluno;
	}

	public void setMatriculaAluno(int matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
