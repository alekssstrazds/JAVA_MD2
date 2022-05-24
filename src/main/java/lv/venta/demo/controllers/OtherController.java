package lv.venta.demo.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.demo.model.Child;
import lv.venta.demo.model.ChildRating;
import lv.venta.demo.model.ChildrenGroup;
import lv.venta.demo.services.IOtherService;

@Controller
@RequestMapping("/child") //localhost:8080/child
public class OtherController {
    @Autowired
    private IOtherService otherService;

    @GetMapping("/rating/{childid}") //localhost:8080/child/rating/1
    public String getRatingByChildId(@PathVariable(name = "childid") int childid, Model model) {
        
        ArrayList<ChildRating> allRatings = otherService.selectAllRatingsByChildId(childid);
        model.addAttribute("package", allRatings);
        return "child-rating-show-page";
    }

    @GetMapping("/rating/all/low") //localhost:8080/child/rating/all/low
    public String getAllRatingLowerThen(Model model) {
        int lowConstant = 1;
        ArrayList<ChildRating> allRatings = otherService.selectAllRatingWhereRatingIsLow(lowConstant);
        model.addAttribute("package", allRatings);
        return "child-rating-show-page";
    }

    @GetMapping("/group/{year}") //localhost:8080/child/group/{year}
    public String getChildGroupByYear(@PathVariable(name = "year") int year, Model model) {
        ArrayList<ChildrenGroup> allChildrens = otherService.selectAllChildByGroupYear(year);
        model.addAttribute("package", allChildrens);
        return "child-all-page";
    }

    @GetMapping("/allergyOla") //localhost:8080/child/allergyOla
    public String getChildGroupByYear(Model model) {
        ArrayList<Child> filtredChilds = otherService.selectAllChildByAllergiesOLA();
        model.addAttribute("package", filtredChilds);
        return "child-all-page";
    }

    @GetMapping("/rating/addNew/{childid}") //localhost:8080/child/addNew/{childid}
    public String getTeacherAdd(@PathVariable(name = "childid") int childid, ChildRating temp)  {   
        return "teacher-add-page";
    }

    @PostMapping("/rating/addNew/{childid}") //localhost:8080/child/addNew/{childid}
    public String postTeacherAdd(@PathVariable(name = "childid") int childid, @Valid ChildRating childRating, BindingResult result) { 
        if(!result.hasErrors()) {
            otherService.insertChildRatingByChildId(childid, childRating);
            return "redirect:/teacher/showAll/" + childRating.getId_rat();
        } else {
            return "teacher-add-page";  
        }
    }
}
