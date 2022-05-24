package lv.venta.demo.services.impl;

import java.util.ArrayList;

import javax.swing.GroupLayout.Group;

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
    //atgriež visus bērnus, kas ir grupiņā, ja ir zināms grupiņas id
    @Override
    public ArrayList<Child> selectAllChildInGroupByGroupId(int id) throws Exception {
        if(childGroupRepo.existsById(id) && childGroupRepo.findById(id).get().equals(id)) {
            return (ArrayList<Child>) childRepo.findAll();
        } throw new Exception("Id nav atrasts!!!"); 
    }
    //izdzēš bērnu no grupiņas, ja ir zināms grupiņas id un bērna id
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
    //pievieno jaunu bērnu sistēmā un to pievieno grupiņai, ja ir zināms grupiņas id
    @Override
    public Child insertNewChild(int id, Child temp) {
        Child newChild = new Child(temp.getName(),temp.getSurname(), temp.getAllergies());
        //saglabājam izveidoto produktu DB
        Child childFromDB = childRepo.save(newChild);
        if(childGroupRepo.existsById(id)) { //TODO japievieno child pie grupas
            
        }

        //atgriežam
        return childFromDB;
    }

    // nomaina esošā bērna grupiņu uz jaunu, ja ir zināms jaunās grupiņas id
    @Override
    public void changeChildByIdGroupById(int childId, int groupId) throws Exception {
        if(childGroupRepo.existsById(groupId)) 
        {
            //iegūstam produktu no DB
            Child child = childRepo.findById(childId).get();
            ChildrenGroup group = childGroupRepo.findById(groupId).get();
            deleteChildByIdFromGroupById(childId, child.getGroup().getId_gr());
            //Mainam objektu uz citu grupi'nu
            if(childGroupRepo.existsById(groupId)) { 
                group.addNewChild(child);
            }
        } throw new Exception("Id nav atrasts!!!");
    }
}
