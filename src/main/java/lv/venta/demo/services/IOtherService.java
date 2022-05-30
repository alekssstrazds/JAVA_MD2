package lv.venta.demo.services;

import java.util.ArrayList;

import lv.venta.demo.model.Child;
import lv.venta.demo.model.ChildRating;
import lv.venta.demo.model.RatingValue;

public interface IOtherService {
    //atgriež visus konkrēta bērna vērtējumus, ja ir zināms bērna id
    public ArrayList<ChildRating> selectAllRatingsByChildId(int id) throws Exception;
    //atgriež visus vērtējumus, kuri ir pazemināti (piemēram, nav_apgūts)
    public ArrayList<ChildRating> selectAllRatingWhereRatingIsLow(RatingValue ratingThreshold) throws Exception;
    //atgriež visus bērnus, kas atrodās grupiņās ar norādītu gadu
    public ArrayList<Child> selectAllChildByGroupYear(int groupYear) throws Exception;
    //atgriež visus bērnus, kam ir alerģija no olas
    public ArrayList<Child> selectAllChildByAllergiesOLA(); 
    //pievieno jaunu izvērtējumu konkrētam bērnam, ja ir zināms bērna id
    public void insertChildRatingByChildId(int id, ChildRating childRating);
    public ArrayList<ChildRating> selectAllRatingWhereRatingIsLow(int lowConstant);
}
