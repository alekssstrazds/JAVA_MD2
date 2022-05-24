package lv.venta.demo.services;

import java.util.ArrayList;

import lv.venta.demo.model.Child;
import lv.venta.demo.model.ChildRating;
import lv.venta.demo.model.ChildrenGroup;
import lv.venta.demo.model.RatingValue;

public interface IOtherService {
    //atgriež visus konkrēta bērna vērtējumus, ja ir zināms bērna id
    public abstract ArrayList<ChildRating> selectAllRatingsByChildId(int id) throws Exception;
    //atgriež visus vērtējumus, kuri ir pazemināti (piemēram, nav_apgūts)
    public abstract ArrayList<ChildRating> selectAllRatingWhereRatingIsLow(RatingValue ratingThreshold) throws Exception;
    //atgriež visus bērnus, kas atrodās grupiņās ar norādītu gadu
    public abstract ArrayList<ChildrenGroup> selectAllChildByGroupYear(int groupYear);
    //atgriež visus bērnus, kam ir alerģija no olas
    public abstract ArrayList<Child> selectAllChildByAllergiesOLA(); 
    //pievieno jaunu izvērtējumu konkrētam bērnam, ja ir zināms bērna id
    public abstract void insertChildRatingByChildId(int id, ChildRating childRating);
}
