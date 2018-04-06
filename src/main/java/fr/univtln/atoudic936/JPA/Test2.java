package fr.univtln.atoudic936.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test2 {
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("testpostgresqllocal");
        EntityManager em = emf.createEntityManager();


        Personne p = em.find(Personne.class, 1);
        System.out.println(p);
        p.setAge(p.getAge()+1);

        EntityTransaction transac = em.getTransaction();
        transac.begin();
        em.persist(p);
        transac.commit();

        em.refresh(p);
        System.out.println(p);

        Chien c = em.find(Chien.class, 2);
        System.out.println(c);
        transac.begin();
        em.remove(c);
        transac.commit();
    }
}
