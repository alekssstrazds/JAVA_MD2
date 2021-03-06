package lv.venta.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.ChildRating;
import lv.venta.demo.model.RatingValue;

public interface IChildRatingRepo extends CrudRepository<ChildRating,Integer> {
	public ArrayList<ChildRating> findByRatingValue(RatingValue nav_apguts);
}