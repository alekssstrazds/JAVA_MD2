package lv.venta.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.model.Child;
import lv.venta.demo.model.ChildrenGroup;
import lv.venta.demo.repo.IChildRepo;
import lv.venta.demo.repo.IChildrenGroupRepo;
import lv.venta.demo.services.IChildService;

@Service
public abstract class ChildServiceImpl implements IChildService{
    @Autowired
    private IChildRepo childRepo;

    @Autowired
    private IChildrenGroupRepo childGroupRepo;
    
    @Override
    public ArrayList<Child> selectAllChildInGroupByGroupId(int id) throws Exception {
        if(childGroupRepo.existsById(id) && childGroupRepo.findById(id).get().equals(id)) {
            return (ArrayList<Child>) childRepo.findAll();
        } throw new Exception("Id nav atrasts!!!"); 
    }
 
    @Override
    public void deleteChildByIdFromGroupById(int groupId, int childId) throws Exception {
        boolean isFound = false;
        if(childGroupRepo.existsById(groupId)) {
            childRepo.deleteById(childId);
            isFound = true;
        } 
        if(!isFound) {
            throw new Exception("Id nav atrasts!!!");
        } 
    }
  
    @Override
    public Child insertNewChild(int id, Child temp) {
        Child newChild = new Child(temp.getName(),temp.getSurname(), temp.getAllergies());
        ChildrenGroup group = childGroupRepo.findById(id).get();
        Child childFromDB = childRepo.save(newChild);
        if(childGroupRepo.existsById(id)) { //TODO japievieno child pie grupas
        	group.addNewChild(newChild);
        }
        return childFromDB;
    }
    
    @Override
    public void changeChildByIdGroupById(int childId, int groupId) throws Exception {
        if(childGroupRepo.existsById(groupId)) 
        {
            Child child = childRepo.findById(childId).get();
            ChildrenGroup group = childGroupRepo.findById(groupId).get();
            deleteChildByIdFromGroupById(childId, child.getGroup().getId_gr());
            
            if(childGroupRepo.existsById(groupId)) { 
                group.addNewChild(child);
            }
        } throw new Exception("Id nav atrasts!!!");
    }
}
