package com.ansa.hierarchy;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by asalkov on 21.08.2015.
 */
public class BookService {
    private EntityManager em = Persistence.createEntityManagerFactory("DBUnitEx").createEntityManager();

    public void save(Book book){
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
    }

    public Book findBook(Long id){
        Book book = (Book)em.createQuery("select b from Book b where b.isbn = :isbn")
                .setParameter("isbn", id).getSingleResult();


        return book;

    }
}
