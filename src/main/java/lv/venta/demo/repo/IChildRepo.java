package lv.venta.demo.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.Child;

public interface IChildRepo extends CrudRepository<Child,Integer> {

}
