package lv.venta.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.model.Child;
import lv.venta.demo.model.ChildRating;
import lv.venta.demo.model.ChildrenGroup;
import lv.venta.demo.model.RatingValue;
import lv.venta.demo.model.Teacher;
import lv.venta.demo.repo.IChildRatingRepo;
import lv.venta.demo.repo.IChildRepo;
import lv.venta.demo.repo.IChildrenGroupRepo;
import lv.venta.demo.services.IOtherService;

@Service
public abstract class OtherServiceImpl implements IOtherService{

    @Autowired
    public IChildRatingRepo childRatingRepo;

    @Autowired
    public IChildrenGroupRepo childrenGroupRepo;
    
    @Autowired
    public IChildRepo childRepo;
    

    //atgriež visus konkrēta bērna vērtējumus, ja ir zināms bērna id
    public ArrayList<ChildRating> selectAllRatingsByChildId(int id) throws Exception {
        if(childRepo.existsById(id)) {
            return (ArrayList<ChildRating>) childRatingRepo.findAll();
        } throw new Exception("Id nav atrasts!!!"); 
    }
    //atgriež visus vērtējumus, kuri ir pazemināti (piemēram, nav_apgūts)
    public ArrayList<ChildRating> selectAllRatingWhereRatingIsLow(RatingValue ratingThreshold) throws Exception {
        if(ratingThreshold.equals(RatingValue.nav_apguts)) { //TODO vienkaarsi return
            //return (ArrayList<ChildRating>) childRatingRepo.findAll();
        } throw new Exception("Id nav atrasts!!!");
    }
    //atgriež visus bērnus, kas atrodās grupiņās ar norādītu gadu
    public ArrayList<Child> selectAllChildByGroupYear(int groupYear) throws Exception {
        if(childrenGroupRepo.existsByGroupYear(groupYear)) {
            ArrayList<Child> result = childRepo.findByGroupYear(groupYear);
            return result;
        } else throw new Exception("Students ar tadu vardu un uzvardu neeksiste");
    }
    //atgriež visus bērnus, kam ir alerģija no olas
    public ArrayList<Child> selectAllChildByAllergiesOLA() {
        String allergies = "OLA";
        return (ArrayList<Child>) childRepo.findAllByAllergies(allergies);
    } 
    //pievieno jaunu izvērtējumu konkrētam bērnam, ja ir zināms bērna id
    public void insertChildRatingByChildId(int id, ChildRating childRating) {
        if(childRepo.existsById(id)) {
            
        }
    }
}