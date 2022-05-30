package lv.venta.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.Child;

public interface IChildRepo extends CrudRepository<Child,Integer> {

	public ArrayList<Child> findByGroupYear(int groupYear);

	public ArrayList<Child> findAllByAllergies(String allergies);

}
