/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import dao.AccountDao;
import java.sql.SQLException;
import java.util.List;
import model.Account;

/**
 *
 * @author FSC
 */
public class AccountService {
    private AccountDao accountDao;

    public AccountService() {
        accountDao = new AccountDao();
    }

    public  List<Account> getAllAccount() throws SQLException{
        return accountDao.getAllAccount();
    }
    
    public void addAccount(Account account) throws SQLException{
        accountDao.addAccount(account);
    }
    
    public Account getUserName(String userName) throws SQLException{
        return accountDao.getAccountByAccountname(userName);
    }
}
