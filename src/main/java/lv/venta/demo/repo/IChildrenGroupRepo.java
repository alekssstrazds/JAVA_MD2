package lv.venta.demo.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.ChildrenGroup;

public interface IChildrenGroupRepo extends CrudRepository<ChildrenGroup,Integer> {
	public boolean existsByGroupYear(int groupYear);
}