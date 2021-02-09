/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenuf2m6_marianavarro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author maria
 */
public class ExamenUf2M6_MariaNavarro {

   public static final String sDriver = "com.mysql.cj.jdbc.Driver";
    public static final String sURL = "jdbc:mysql://localhost:3306/examenuf2";
    public static final String sUSERNAME = "root";
    public static final String sPASSWORD = "";
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conexio = null;
        conexio = conexioJDBC();
    }
    
    public static Connection conexioJDBC () throws SQLException, ClassNotFoundException {
        Connection conexio = null;
        
        try {
            Class.forName(sDriver);
            conexio = DriverManager.getConnection(sURL,sUSERNAME,sPASSWORD);
            JOptionPane.showMessageDialog(null, "Conexio feta");
        } catch (Exception e) {
            System.out.println("error");
        }
        
        return conexio;
    }
}
