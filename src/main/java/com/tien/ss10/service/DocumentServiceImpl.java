package com.tien.ss10.service;

import com.tien.ss10.model.Document;
import com.tien.ss10.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public boolean save(Document document) {
        return documentRepository.save(document);
    }
}
