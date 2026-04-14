package recursos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Config {
	
	private static EntityManagerFactory emf;
		
	// Garante a existência da "fábrica"
    public static EntityManagerFactory getFactory() {
        if (emf == null) {
            try {
                emf = Persistence.createEntityManagerFactory("At1BI-Biblioteca");
            } catch (Exception e) {
                System.err.println("Erro ao inicializar a Factory!");
                e.printStackTrace();
            }
        }
        return emf;
    }

    //Responsável por instanciar a EntityManager
    public static EntityManager getEntityManager() {
        return getFactory().createEntityManager();
    }
    
    // Testa a Conexão
    public static boolean TesteConexao() {
    	try {
    		EntityManager em = getEntityManager();
    		em.isOpen();
    		System.out.println("Conexão realizada com sucesso!\n");
    		System.out.println("-----------------------------------\n\n");
    		em.close();
    		return true;
    	}catch(Exception e) {
    		System.err.println("Erro ao conectar ao banco. Verifique o nome no persistence.xml.");
            e.printStackTrace();
            return false;
    	}
    }
    
    // Fechar a "fábrica" - e SOMENTE ela 
    public static void fechar() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            System.out.println("Factory encerrada com sucesso!");
        }
    }
}
