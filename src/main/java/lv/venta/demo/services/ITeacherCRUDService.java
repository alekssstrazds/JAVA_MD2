package lv.venta.demo.services;

import java.util.ArrayList;

import lv.venta.demo.model.Teacher;

public interface ITeacherCRUDService {
    
    //create
    public abstract Teacher insertNewTeacher(Teacher temp);
    //read all
    public abstract ArrayList<Teacher> getAllTeachers();
    //read by id
    public abstract Teacher getTeacherById(int id);
    //update
    public abstract void updateTeacherById(int id, Teacher temp);
    //delete
    public abstract void  deleteTeacherById(int id);
}
