package entidade;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmprestimo;
	private LocalDate dataDevolucao;
	private LocalDate dataEmprestimo;
	
	@ManyToOne
	@JoinColumn(name = "id_publicacao")
	private Publicacao publicacao;
	
	@ManyToOne
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;
	
	public Emprestimo() {
	}

	public Emprestimo(LocalDate dataDevolucao, LocalDate dataEmprestimo, Publicacao publicacao,
			Aluno aluno) {
		super();
		this.dataDevolucao = dataDevolucao;
		this.dataEmprestimo = dataEmprestimo;
		this.publicacao = publicacao;
		this.aluno = aluno;
	}

	public int getIdEmprestimo() {
		return idEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
