package com.tien.ss10.service;

import com.tien.ss10.model.File;
import com.tien.ss10.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServieImpl implements FileServie {

    @Autowired
    private FileRepository fileRepository;


    @Override
    public boolean save(File file) {
        return fileRepository.save(file);
    }
}
