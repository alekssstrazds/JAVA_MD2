package lv.venta.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.model.Teacher;
import lv.venta.demo.repo.ITeacherRepo;
import lv.venta.demo.services.ITeacherCRUDService;

@Service
public abstract class TeacherCRUDServiceImpl implements ITeacherCRUDService {
    @Autowired
    public ITeacherRepo teacherRepo;
    
    @Override
    public Teacher insertNewTeacher(Teacher temp) {
        Teacher newTeacher = new Teacher(temp.getName(),temp.getSurname());
        Teacher teacherFromDB = teacherRepo.save(newTeacher);
        return teacherFromDB;
    }
    @Override
    public ArrayList<Teacher> getAllTeachers() {
        return (ArrayList<Teacher>) teacherRepo.findAll();
    }
    @Override
    public Teacher getTeacherById(int id) throws Exception {
        if(teacherRepo.existsById(id)) {
            return teacherRepo.findById(id).get();
        } throw new Exception("Id nav atrasts!!!"); 
    }
    
    @Override
    public void updateTeacherById(int id, Teacher temp) throws Exception{
        if(teacherRepo.existsById(id)) 
        {
            Teacher teacher = teacherRepo.findById(id).get();
            if(!teacher.getName().equals(temp.getName())) {
                teacher.setName(temp.getName()); 
            }
            if(teacher.getSurname().equals(temp.getSurname())) {
                teacher.setSurname(temp.getSurname());
            }
            teacherRepo.save(teacher);
        } throw new Exception("Id nav atrasts!!!");
    }
    
    @Override
    public void deleteTeacherById(int id) throws Exception {
        boolean isFound = false;
        if(teacherRepo.existsById(id)) {
            teacherRepo.deleteById(id);
            isFound = true;
        } 
        if(!isFound) {
            throw new Exception("Id nav atrasts!!!");
        }
    }
}
