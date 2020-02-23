package com.sysoiev.hibernate;

import com.sysoiev.hibernate.entity.Author;
import com.sysoiev.hibernate.entity.Book;
import org.hibernate.Session;

public class Start {


    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Author author1 = new Author("testing");
        new AuthorHelper().addAuthor(author1);

        for (Author author : new AuthorHelper().getAuthorList()
        ) {
            System.out.println("author = " + author.getName());

        }
        for (Book book : new BookHelper().getBookList()
        ) {
            System.out.println("book = " + book.getName());

        }
        HibernateUtil.getSessionFactory().close(); // закрываем фабрику, иначе программа останется в "зависнутом состоянии"


    }
}


