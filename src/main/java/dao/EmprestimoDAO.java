package dao;

import java.util.List;

import entidade.Emprestimo;
import jakarta.persistence.EntityManager;

public class EmprestimoDAO {
	
	private EntityManager em;
	
	public EmprestimoDAO (EntityManager em) {
		this.em = em;
	}
	
//################## SALVAR ################## 	
	public void salvar(Emprestimo emprestimo) {
	try {
		em.getTransaction().begin();
		em.persist(emprestimo);
		em.getTransaction().commit();
		System.out.println("Empréstimo realizado com sucesso");
	}catch(Exception e) {
		em.getTransaction().rollback();
		e.printStackTrace();
	}
}

//################## CONSULTAR ID ##################  
	public Emprestimo consultarPorId(Integer id) {
		String query = "SELECT e FROM Emprestimo e WHERE e.idEmprestimo = :id";
		try{
			return em.createQuery(query, Emprestimo.class)
					.setParameter("id", id)
					.getSingleResult();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		}
	
//################## ALTERAR ################## 
	public void alterar(Emprestimo emprestimo) {
	    try {
	        em.getTransaction().begin();
	        em.merge(emprestimo); // atualizar se existir, criar se for novo
	        em.getTransaction().commit();
	        System.out.println("Alterado com sucesso!");
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        System.out.println("Erro ao Alterar!");
	        e.printStackTrace();
	    }
	}

//################## EXCLUIR ################## 
	public void excluir(Integer id) {
	    String query = "DELETE FROM Emprestimo e WHERE e.idEmprestimo = :id"; 
	    try {
	        em.getTransaction().begin();
	        int linhasAfetadas = em.createQuery(query)
	            .setParameter("id", id)
	            .executeUpdate();   
	        if (linhasAfetadas > 0) {
	            System.out.println("Empréstimo excluído!");
	            System.out.println("Quantidade: " + linhasAfetadas);
	        }
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    }
	}

//################## CONSULTAR NOMES ##################  
	public List<Emprestimo> buscarPorNomeAluno(String nome) {
		String query = "SELECT e FROM Emprestimo e WHERE e.aluno.nome LIKE :nome";
	    return em.createQuery(query, Emprestimo.class)
	             .setParameter("nome", "%" + nome + "%")
	             .getResultList();
	}
	
	//##################  CONSULTAR TODOS ################## 
	public List<Emprestimo> BuscarTodos(){
		String query = "SELECT e FROM Emprestimo e";
		return em.createQuery(query, Emprestimo.class)
				.getResultList();
	}
}
