package com.sysoiev.hibernate;

import com.sysoiev.hibernate.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BookHelper {
    private SessionFactory sessionFactory;

    public BookHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Book> getBookList() {

        // открыть сессию - для манипуляции с персист. объектами
        Session session = sessionFactory.openSession();

       // session.get(Book.class, 1L); // получение объекта по id


        // этап подготовки запроса

        // объект-конструктор запросов для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated

        CriteriaQuery cq = cb.createQuery(Book.class);

        Root<Book> root = cq.from(Book.class);// первостепенный, корневой entity (в sql запросе - from)

        cq.select(root);// необязательный оператор, если просто нужно получить все значения


        // этап выполнения запроса
        Query query = session.createQuery(cq);

        List<Book> bookList = query.getResultList();

        session.close();

        return bookList;

    }

    public Book getBook(String name) {
        return null;
    }
}
