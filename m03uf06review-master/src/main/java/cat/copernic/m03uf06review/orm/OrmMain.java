/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.orm;

import cat.copernic.m03uf06review.jdbc.Connexio;
import cat.copernic.m03uf06review.jdbc.JdbcMain;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * En aquesta secció cal accedir a una taula de MySQL amb un camp de cada tipus:
 *
 * int o long, double o float, boolean, char, String i java.sql.Date
 *
 * Recòrrer el result set i mostrar-lo per la consola com a instancies de la
 * classe Registre, que tindrà l'estructura de la teva taula.
 *
 *
 * @author pep
 */
public class OrmMain {

    private static ArrayList<Cotxes> ctx = new ArrayList<>();

    public static void main(String[] args) {
        obteCotxes();
        mostraCotxes();
    }

    private static void obteCotxes() {
        Connexio c = new Connexio();

        try {
            String query = "select * from cotxe";

            PreparedStatement st = c.getConexio().prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Cotxes ct = new Cotxes(rs.getString("Model"), rs.getInt("Potencia_motor"), rs.getFloat("Acceleracio_cent"), rs.getBoolean("Origen_europeu"), rs.getDate("Data_fabricacio"));
                afegeixCotxes(ct);
            }

        } catch (SQLException ex) {Logger.getLogger(JdbcMain.class.getName()).log(Level.SEVERE, null, ex);}
    }

    private static ArrayList<Cotxes> afegeixCotxes(Cotxes ct) {
        ctx.add(ct);
        return ctx;
    }

    private static void mostraCotxes() {
        for (int i = 0; i < ctx.size(); i++) {
            System.out.println(ctx.get(i));
        }
    }

}
