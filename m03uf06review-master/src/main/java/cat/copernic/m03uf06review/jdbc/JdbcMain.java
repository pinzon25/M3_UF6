/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.jdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * En aquesta secció cal accedir a una taula de MySQL amb un camp de cada tipus:
 *
 * int o long, double o float, boolean, char, String i java.sql.Date
 *
 * Recòrrer el result set i mostrar-lo per la consola.
 *
 *
 * @author pep
 */
public class JdbcMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { //Per a la proxima vegada, estructurar mes en metodes, mantenir el main net.

        Connexio c = new Connexio();

        try {
            String query = "select * from cotxe";

            PreparedStatement st = c.getConexio().prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                System.out.println("Model: " + rs.getString("Model") + "\n" + "Potencia(Cv): " + rs.getInt("Potencia_motor") + "\n" + "Acceleracio(0-100Km/h): " + rs.getFloat("Acceleracio_cent") + " s" + "\n" + "Es europeu: " + rs.getBoolean("Origen_europeu") + "\n" + "Data de fabricacio del model: " + rs.getDate("Data_fabricacio") + "\n\n");
            }

        } catch (SQLException ex) {
            Logger.getLogger(JdbcMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
