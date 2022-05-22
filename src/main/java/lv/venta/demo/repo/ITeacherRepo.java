package lv.venta.demo.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.Teacher;

public interface ITeacherRepo extends CrudRepository<Teacher,Integer> {

}
