package com.tien.ss10.service;

import com.tien.ss10.model.Project;

public interface ProjectService {
    boolean save(Project project);
    boolean update(Project project);
    boolean delete(int id);
}
