package ifba.edu.br.principal;

import java.util.List;

import ifba.edu.br.basica.Categoria;
import ifba.edu.br.basica.Cliente;
import ifba.edu.br.dao.GetEntityManager;
import jakarta.persistence.EntityManager;


public class Principal {
    public static void main(String[] args) {
        EntityManager em = GetEntityManager.getConnectionJpa();
        Categoria C = new Categoria("Categoria Teste");
        Categoria C2 = new Categoria("teste 2");
        
    
      /*   em.getTransaction().begin();
        em.persist(C);
        em.persist(C2);
        em.getTransaction().commit();*/

        Cliente c = new Cliente();
        c.setNome("Jorge");
        c.setRg("123456");
        c.setCpf("12345678911");
        c.setCategoria(em.find(Categoria.class, 1));
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();

        List<Categoria> list = em.createQuery("select c from Cliente c", Categoria.class).getResultList();
        list.forEach(System.out::println);

    }
    
}
