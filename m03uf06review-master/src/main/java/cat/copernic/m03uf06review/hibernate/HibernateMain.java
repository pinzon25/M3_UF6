/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.hibernate;

import cat.copernic.m03uf06review.jdbc.Connexio;
import cat.copernic.m03uf06review.orm.Cotxes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * En aquesta secció cal accedir a una taula de MySQL amb un camp de cada tipus:
 *
 * int o long, double o float, boolean, char, String i java.sql.Date
 *
 * Recòrrer el result set i mostrar-lo per la consola com a instancies de la
 * classe Registre, que tindrà l'estructura de la teva taula.
 *
 * Cal usar la llibreria Hibernate.
 *
 *
 * @author pep
 */
public class HibernateMain {

    static SessionFactory fct = null;
    static Session session = null;
    static SimpleDateFormat sdf = null;
    static java.sql.Date sqlDate = null;

    public static void main(String[] args) throws ParseException {
        converteixData("1963-12-17");
        //Cotxes cotxe = new Cotxes(13, "Nissan GTR", 670, (float) 3.0, false, sqlDate);
        Cotxes cotxe1 = new Cotxes(14, "lancia delta integrale", 700, (float) 2.0, true, sqlDate);
        configuraSessio();
        obreSessio();
        llistaCotxes();
        //insereixCotxe(cotxe1);
        //eliminaCotxe(13);
        //actualitzaCotxe(cotxe1);
    }

    private static java.sql.Date converteixData(String data) throws ParseException {
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d;
        d = new Date();
        d = sdf.parse(data);
        sqlDate = new java.sql.Date(d.getTime());

        return sqlDate;
    }

    private static void llistaCotxes() {
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List cotxes = session.createQuery("FROM Cotxes").list();
            System.out.println("\n------------COTXES------------");
            for (Iterator iterator = cotxes.iterator(); iterator.hasNext();) {
                Cotxes cotxe = (Cotxes) iterator.next();
                System.out.println(cotxe);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.close();
        }
    }

    private static SessionFactory configuraSessio() {
        fct = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        return fct;
    }

    private static Session obreSessio() {
        session = fct.openSession();
        return session;
    }

    //private static void insereixCotxe(int id, String model, int potencia, float acceleracio, boolean europeu, String dataFab) throws ParseException {
    private static void insereixCotxe(Cotxes cotxe) throws ParseException {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(cotxe);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.close();
        }
    }

    private static void eliminaCotxe(int id) {

        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Cotxes cotxe = (Cotxes) session.get(Cotxes.class, id);
            session.delete(cotxe);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.close();
            System.out.println("Cotxe eliminat correctament.");
        }
    }

    private static void actualitzaCotxe(Cotxes cotxe/*int id, int potencia*/) {
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.get(Cotxes.class, cotxe.getId());
            session.merge(cotxe);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.close();
        }
    }
}
