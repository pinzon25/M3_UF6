/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author riki
 */
public class Connexio {

    private final String usuari = "Ricard";
    private final String contrasenya = "1234";
    private final String bbdd = "Cotxes";
    private final String url = "jdbc:mysql://localhost:3306/" + bbdd;

    private Connection con = null;

    public Connection getConexio() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 

            con = DriverManager.getConnection(url + "?useUnicode=true&"
                    + "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", usuari, contrasenya);

            System.out.println("Connexio establerta amb la base de dades: " + bbdd + "\n\n");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connexio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Connexio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

}
