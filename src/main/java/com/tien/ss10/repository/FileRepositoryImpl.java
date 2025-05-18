package com.tien.ss10.repository;

import com.tien.ss10.config.ConnectionDB;
import com.tien.ss10.model.File;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;

@Repository
public class FileRepositoryImpl implements FileRepository {


    @Override
    public boolean save(File file) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call save_file(?,?)}");
            callSt.setString(1,file.getFilename());
            callSt.setString(2,file.getDescription());

            callSt.executeUpdate();
            result = true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
