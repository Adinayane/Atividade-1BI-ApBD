package main;

import java.time.LocalDate;
import java.util.List;

import dao.EmprestimoDAO;
import entidade.Aluno;
import entidade.Emprestimo;
import entidade.Publicacao;
import jakarta.persistence.EntityManager;
import recursos.Config;

public class TesteBiblioteca {

	public static void main(String[] args) {
		Config.TesteConexao();
		
		//TesteSalvar();
		//TesteExcluir();
		//TesteAlterar();
		//TesteBuscarTodos();
		//TesteBuscaId();
		//TesteBuscarNome();
		

		// Fecha a EntityManagerFactory
		//Config.fechar(); 
	}
	
	public static void TesteSalvar() {
		int idAluno = 4;
		int idPublicacao = 1;
		int diasReserva = 9;
		
		EntityManager em = Config.getEntityManager();
		EmprestimoDAO empdao = new EmprestimoDAO(em);
		Emprestimo emp = new Emprestimo();
		
		Aluno aluno1 = em.find(Aluno.class, idAluno);
		Publicacao pub1 = em.find(Publicacao.class, idPublicacao);
		
		emp.setDataEmprestimo(LocalDate.now());
		emp.setDataDevolucao(LocalDate.now().plusDays(diasReserva));
		emp.setAluno(aluno1);
		emp.setPublicacao(pub1);
		
		empdao.salvar(emp);
		
		em.close();
	}
	
	public static void TesteBuscarTodos() {
		EntityManager em = Config.getEntityManager();
		EmprestimoDAO empdao = new EmprestimoDAO(em);
		List<Emprestimo> lista = empdao.BuscarTodos();
		
		System.out.println("Empréstimos: \n");
		System.out.println("Código - Livro - Emprestador por - Dia Emprestado - Devolver ");
		for(Emprestimo e: lista) {
			System.out.println(e.getIdEmprestimo() + " - " 
					+ e.getPublicacao().getTitulo() + " - "
					+ e.getAluno().getNome() + " - "
					+ e.getDataEmprestimo() + " - "
					+ e.getDataDevolucao() + "\n" );
		}
		em.close();
	}

	public static void TesteExcluir() {
		int idParaExcluir = 6;
		
		EntityManager em = Config.getEntityManager();
		EmprestimoDAO dao = new EmprestimoDAO(em);
		Emprestimo emp = dao.consultarPorId(idParaExcluir);
		
		if(emp != null)
			dao.excluir(emp.getIdEmprestimo());
		else
			System.out.println("Id não encontrado para exclusão.");
		
		em.close();
	}

	public static void TesteBuscaId() {
		int idParaConsultar = 6;
		
		EntityManager em = Config.getEntityManager();
		EmprestimoDAO dao = new EmprestimoDAO(em);
		Emprestimo emp = dao.consultarPorId(idParaConsultar);
		
		if(emp!= null) {
		System.out.println("Empréstimo Código Nº: " + emp.getIdEmprestimo() + "\n");
		System.out.println("Livro - Emprestador por - Dia Emprestado - Devolver\n ");
		System.out.println(emp.getPublicacao().getTitulo() + " - "
					+ emp.getAluno().getNome() + " - "
					+ emp.getDataEmprestimo() + " - "
					+ emp.getDataDevolucao() + "\n");
		}else {
			System.out.println("Empréstimo com o Código " + idParaConsultar + " não encontrado");
		}
		
		em.close();
	}

	public static void TesteAlterar() {
		int idAluno = 2;
		int idPublicacao = 4;
		int idEmprestimo = 7;
		int diasReserva = 10;
		
		EntityManager em = Config.getEntityManager();
		EmprestimoDAO dao = new EmprestimoDAO(em);
		Emprestimo emp = dao.consultarPorId(idEmprestimo);
		
		Aluno aluno = em.find(Aluno.class, idAluno);
		Publicacao pub = em.find(Publicacao.class, idPublicacao);
		
		emp.setAluno(aluno);
		emp.setPublicacao(pub);
		emp.setDataEmprestimo(LocalDate.now());
		emp.setDataDevolucao(LocalDate.now().plusDays(diasReserva));
		
		dao.alterar(emp);
		
		em.close();
	}

	public static void TesteBuscarNome() {
		String nome = "Lucas";
		
		EntityManager em = Config.getEntityManager();
		EmprestimoDAO dao = new EmprestimoDAO(em);
		
		List<Emprestimo> lista = dao.buscarPorNomeAluno(nome);
		
		if(lista.isEmpty()) {
			System.out.println("Não há empréstimos para este aluno.");
		}else {
		System.out.println("Empréstimos de "+ nome + "\n");
		System.out.println("Código - Livro - Dia Emprestado - Devolver ");
		for(Emprestimo e: lista) {
			System.out.println(e.getIdEmprestimo() + " - " 
					+ e.getPublicacao().getTitulo() + " - "
					+ e.getDataEmprestimo() + " - "
					+ e.getDataDevolucao() + "\n" );
		}
		}
		
		em.close();
	}
}
