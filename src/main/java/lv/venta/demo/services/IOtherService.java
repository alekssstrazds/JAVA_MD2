package lv.venta.demo.services;

import java.util.ArrayList;

import lv.venta.demo.model.ChildRating;
import lv.venta.demo.model.ChildrenGroup;

public interface IOtherService {
    //atgriež visus konkrēta bērna vērtējumus, ja ir zināms bērna id
    public abstract ArrayList<ChildRating> selectAllRatingsByChildId(int id);
    //atgriež visus vērtējumus, kuri ir pazemināti (piemēram, nav_apgūts)
    public abstract ArrayList<ChildRating> selectAllRatingWhereRatingIsLow(int ratingThreshold);
    //atgriež visus bērnus, kas atrodās grupiņās ar norādītu gadu
    public abstract ArrayList<ChildrenGroup> selectAllChildByGroupYear(int yearThreshold);
    //atgriež visus bērnus, kam ir alerģija no olas
    public abstract void selectAllChildByAllergiesOLA(); 
    //pievieno jaunu izvērtējumu konkrētam bērnam, ja ir zināms bērna id
    public abstract void insertChildRatingByChildId(int id, ChildRating childRating);
}
