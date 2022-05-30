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
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.demo.model.Teacher;
import lv.venta.demo.services.ITeacherCRUDService;

@Controller
@RequestMapping("/teacher") //localhost:8080/teacher
public class TeacherCRUDController {
    @Autowired
    private ITeacherCRUDService teacherService;

    @GetMapping("/showAll") //localhost:8080/teacher/showAll
    public String getTeacherAll(Model model) {
        ArrayList<Teacher> allTeachers = teacherService.getAllTeachers();
        model.addAttribute("package", allTeachers);
        return "teacher-all-page";
    }
    @GetMapping("/showAll/{id}") //localhost:8080/teacher/showAll/1
    public String getTeacherById(@PathVariable(name = "id") int id, Model model) 
    {
        try {
            Teacher temp = teacherService.getTeacherById(id);
            model.addAttribute("package", temp);
            return "teacher-one-page"; //parāda teacher-one-page.html lapu ar package
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page"; //atvērs error-page.html lapu
        }
    }
    @GetMapping("/one") //localhost:8080/teacher/one?id=0
    public String getTeacherOne(@RequestParam(name="id") int id, Model model){
        try {
            Teacher temp = teacherService.readTeacherById(id);
            model.addAttribute("package", temp);
            return "product-one-page"; //parāda teacher-one-page.html lapu ar package
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page"; //atvērs error-page.html lapu
        }
    }
    @GetMapping("/remove/{id}") //localhost:8080/teacher/remove/1
    public String getTeacherDelete(@PathVariable(name="id") int id, Model model) {
        try {
            teacherService.deleteTeacherById(id);
            model.addAttribute("package", teacherService.getAllTeachers());
            return "all-product-page";
        } catch (Exception e) {
            e.printStackTrace();
            return "error-page"; //parādam error-page.html
        }
    }

    @GetMapping("/addNew") //localhost:8080/teacher/addNew
    public String getTeacherAdd(Teacher temp)  {   
        return "teacher-add-page";
    }

    @PostMapping("/addNew") //localhost:8080/teacher/add
    public String postTeacherAdd(@Valid Teacher teacher, BindingResult result) { 
        if(!result.hasErrors()) {
            teacherService.insertNewTeacher(teacher);
            return "redirect:/teacher/showAll/" + teacher.getId_te();
        } else {
            return "teacher-add-page";  
        }
    }
    
    @GetMapping("/update/{id}") //localhost:8080/teacher/update/id
    public String getTeacherUpdate(@PathVariable(name="id") int id, Model model) {
        try {
            Teacher temp = teacherService.getTeacherById(id);
            model.addAttribute("product", temp);
            return "teacher-update-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page"; //atvērs error-page.html lapu
        }
    }
    
    @PostMapping("update/{id}") //localhost:8080/teacher/update/id
    public String getTeacherUpdate(@PathVariable(name="id") int id, @Valid Teacher teacher, BindingResult result) { 
        if(!result.hasErrors()) {
            try {
                teacherService.updateTeacherById(id, teacher);
                return "redirect:/teacher/all/" + id;
            } catch (Exception e) {
                return "redirect:/teacher/all";
            }
        } else {
            return "teacher-update-page";
        }
    }
}
