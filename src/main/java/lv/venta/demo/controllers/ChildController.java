package lv.venta.demo.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.demo.model.Child;
import lv.venta.demo.services.IChildService;

@Controller
@RequestMapping("/child") //localhost:8080/child
public class ChildController {
    @Autowired
    private IChildService childService;

    @GetMapping("/showAll/{groupid}") //localhost:8080/child/showAll/1
    public String getChildByGroupId(@PathVariable(name = "groupid") int groupid, Model model) 
    {
        try {
            ArrayList<Child> temp = childService.selectAllChildInGroupByGroupId(groupid);
            model.addAttribute("package", temp);
            return "child-all-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page"; //atvērs error-page.html lapu
        }
    }
    @GetMapping("/remove/{groupid}/{childid}") //localhost:8080/child/remove/1/1
    public String getChildDelete(@PathVariable(name="groupid") int groupid, @PathVariable(name="childid") int childid, Model model) {
        try {
            childService.deleteChildByIdFromGroupById(groupid, childid);
            model.addAttribute("package", childService.selectAllChildInGroupByGroupId(groupid));
            return "child-all-page";
        } catch (Exception e) {
            e.printStackTrace();
            return "error-page"; //parādam error-page.html
        }
    }

    @GetMapping("/addNew/{groupid}") //localhost:8080/child/addNew/1
    public String getTeacherAdd(@PathVariable(name="groupid") int groupid, Child temp) {   
        return "child-add-page";
    }

    @PostMapping("/addNew/{groupid}") //localhost:8080/child/addNew/1
    public String postTeacherAdd(@PathVariable(name="groupid") int groupid, @Valid Child child, BindingResult result) { 
        if(!result.hasErrors()) {
            childService.insertNewChild(groupid, child);
            return "redirect:/child/showAll/" + child.getId_ch();
        } else {
            return "child-add-page";  
        }
    }

    @GetMapping("/changeGroup/{childId}/{newGroupId}") //localhost:8080/child/addNew/1
    public String getTeacherAdd(@PathVariable(name="childId") int childId, @PathVariable(name="newGroupId") int newGroupId, Child temp) {   
        return "child-all-page";
    }
}
