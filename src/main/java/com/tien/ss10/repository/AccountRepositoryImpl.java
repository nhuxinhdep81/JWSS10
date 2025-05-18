package com.tien.ss10.repository;

import com.tien.ss10.config.ConnectionDB;
import com.tien.ss10.model.Account;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Override
    public boolean save(Account account) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call save_account(?,?,?)}");
            callSt.setString(1, account.getUsername());
            callSt.setString(2, account.getPassword());
            callSt.setString(3, account.getEmail());
            callSt.executeUpdate();
            result = true;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }
}
