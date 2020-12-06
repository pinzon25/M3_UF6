/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.hibernate;

import cat.copernic.m03uf06review.jdbc.Connexio;
import cat.copernic.m03uf06review.orm.Cotxes;
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

    public static void main(String[] args) {
        configuraSessio();
        obreSessio();
        llistaCotxes();
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
            session.close();
        }
    }

    private static SessionFactory configuraSessio() {
        fct = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); //Nom del fitxer pelat.
        return fct;
    }

    private static Session obreSessio() {
        session = fct.openSession();
        return session;
    }

}
