package com.ansa.hierarchy;

import com.ansa.Person;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


public class DiscService {
    private EntityManager em = Persistence.createEntityManagerFactory("DBUnitEx").createEntityManager();

    public void saveDisc(Disc disc){
        em.getTransaction().begin();
        em.persist(disc);
        em.getTransaction().commit();
    }

    public List<Disc> getAll() {
        TypedQuery<Disc> namedQuery = em.createNamedQuery("Disc.getAll",Disc.class);

        return namedQuery.getResultList();
    }

}
