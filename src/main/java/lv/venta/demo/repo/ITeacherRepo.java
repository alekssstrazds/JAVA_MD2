package lv.venta.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.Teacher;

public interface ITeacherRepo extends CrudRepository<Teacher,Integer> {

    default ArrayList<Teacher> getAllTeacher() {
        return (ArrayList<Teacher>) findAll();
    }

}
