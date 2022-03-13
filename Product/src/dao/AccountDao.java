/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author FSC
 */
public class AccountDao {
    public List<Account> getAllAccount() throws SQLException {
        List<Account> accounts = new ArrayList<Account>();
        String sql = "select * from Account";
        try {
            Connection connection = JDBCConnection.JDBCConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setUserName(rs.getString("UserName"));
                account.setPass(rs.getString("Pass"));
                accounts.add(account);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return accounts;
    }
    
    public void addAccount(Account account) throws SQLException {

        try {
            Connection connection = JDBCConnection.JDBCConnection();
            String sql = "insert into Account values (?,?)";
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, account.getUserName());
            preparedStatement.setString(2, account.getPass());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Account getAccountByAccountname(String userName) throws SQLException {
        Connection conn = JDBCConnection.JDBCConnection();
        String sql = "SELECT *  FROM Account WHERE UserName=?";

        Account user = new Account();
        try {
            PreparedStatement stm;
            stm = conn.prepareStatement(sql);
            stm.setString(1, userName);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                user.setUserName(rs.getString("UserName"));
                user.setPass(rs.getString("Pass"));
                return user;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
