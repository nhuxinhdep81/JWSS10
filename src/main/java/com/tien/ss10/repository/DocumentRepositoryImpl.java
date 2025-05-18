package com.tien.ss10.repository;

import com.tien.ss10.config.ConnectionDB;
import com.tien.ss10.model.Document;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;

@Repository
public class DocumentRepositoryImpl implements DocumentRepository {

    @Override
    public boolean save(Document document) {
        Connection conn = null;
        CallableStatement callStt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callStt = conn.prepareCall("{call save_document(?,?,?)}");
            callStt.setString(1,document.getTitle());
            callStt.setString(2,document.getDescription());
            callStt.setString(3, document.getFileUrl());

            callStt.executeUpdate();
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
