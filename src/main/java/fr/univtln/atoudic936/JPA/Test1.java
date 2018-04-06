package fr.univtln.atoudic936.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static java.lang.Thread.sleep;

/**
 * Hello world!
 *
 */
public class Test1
{
    public static void main( String[] args )
    {
        EntityManager em = null;
        int i;
        for (i = 0; i < 10; i++) {
            try {
                EntityManagerFactory emf = Persistence
                        .createEntityManagerFactory("testpostgresqllocal");
                em = emf.createEntityManager();
                i = 11;
            }
            catch (Exception e){
                try {
                    sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }

        if (i == 10){
            System.exit(1);
        }

        Personne p1 = new Personne("Pierre","Durand");

        Chien c1 = new Chien(), c2 = new Chien();
        c1.setNom("Cyril");
        c2.setNom("testouse");
        c2.setProprio(p1);
        c1.setProprio(p1);

        Chenil ch1 = new Chenil();
        c1.setChenil(ch1);
        c2.setChenil(ch1);

        Pathologie pa1 = new Pathologie();
        pa1.setNom("Flemme");
        c2.addPathologie(pa1);
        c1.addPathologie(pa1);

        EntityTransaction transac = em.getTransaction();

        transac.begin();
        em.persist(p1);
        em.persist(c1);
        em.persist(c2);
        em.persist(ch1);
        em.persist(pa1);
        transac.commit();

        em.refresh(p1);
        em.refresh(c1);
        System.out.println(p1);
        System.out.println(c1);
    }
}
