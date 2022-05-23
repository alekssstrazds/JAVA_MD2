package lv.venta.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.repo.ITeacherRepo;
import lv.venta.demo.services.ITeacherCRUDService;

@Service
public abstract class TeacherCRUDServiceImpl implements ITeacherCRUDService {
    @Autowired
    public ITeacherRepo teacherRepo;
}
