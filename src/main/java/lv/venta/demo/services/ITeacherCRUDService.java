package lv.venta.demo.services;

import java.util.ArrayList;

import lv.venta.demo.model.Teacher;

public interface ITeacherCRUDService {
    
    //create
    public Teacher insertNewTeacher(Teacher temp);
    //read all
    public ArrayList<Teacher> getAllTeachers();
    //read by id
    public Teacher getTeacherById(int id) throws Exception;
    //update
    public void updateTeacherById(int id, Teacher temp) throws Exception;
    //delete
    public void  deleteTeacherById(int id) throws Exception;
	public Teacher readTeacherById(int id) throws Exception;
}
