package lv.venta.demo.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.ChildRating;

public interface IChildRatingRepo extends CrudRepository<ChildRating,Integer> {

}