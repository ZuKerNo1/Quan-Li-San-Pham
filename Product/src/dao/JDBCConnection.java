/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author FSC
 */
public class JDBCConnection {
    public static Connection JDBCConnection() throws SQLServerException, SQLException{
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("0934804796a");
        ds.setServerName("LAPTOP-9TCJRCKI\\KVU");
        ds.setPortNumber(1433);
        ds.setDatabaseName("BTCoBan2");
        ds.setEncrypt(false);
        ds.setTrustServerCertificate(false);
        Connection con = null;
        try {
            return ds.getConnection();
            
        }
            // Handle any errors that may have occurred.
            catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
