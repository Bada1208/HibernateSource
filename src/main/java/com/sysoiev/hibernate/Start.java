package com.sysoiev.hibernate;

import org.hibernate.Session;

public class Start {


    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        HibernateUtil.getSessionFactory().close(); // закрываем фабрику, иначе программа останется в "зависнутом состоянии"


    }
}


