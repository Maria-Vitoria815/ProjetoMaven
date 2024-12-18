package basica;

public class Principal {

    public static void main(String[] args) {
        
        EntityManager em = GetEntityManager.getConnectionJpa();

        Categoria cat = new Categoria();
        cat.setDescricao("Professores");

        em.getTransaction().begin();

        em.persist(cat);

        em.getTransaction()
    }
    
}
