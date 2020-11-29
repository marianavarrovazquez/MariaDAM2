/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6_act1_maria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author maria
 */
public class M6_act1_maria {
    
    Connection conexio = null;
    String sDriver = "com.mysql.jdbc.Driver";
    String sURL = "jdbc:mysql://localhost:3306/";
    
    public Connection conexioJDBC () throws SQLException, ClassNotFoundException {
        Class.forName(sDriver);
        conexio = DriverManager.getConnection(sURL,"root","");
        return conexio;
    }
}
