package lv.venta.demo.services;

import java.util.ArrayList;

import lv.venta.demo.model.Child;
import lv.venta.demo.model.ChildrenGroup;

public interface IChildService {
    //atgriež visus bērnus, kas ir grupiņā, ja ir zināms grupiņas id
    public abstract ArrayList<Child> selectAllChildInGroupByGroupId(int id);
    //izdzēš bērnu no grupiņas, ja ir zināms grupiņas id un bērna id
    public abstract void deleteChildByIdFromGroupById(int groupId, int childId);
    //pievieno jaunu bērnu sistēmā un to pievieno grupiņai, ja ir zināms grupiņas id
    public abstract Child insertNewChild(int id, Child temp);
    // nomaina esošā bērna grupiņu uz jaunu, ja ir zināms jaunās grupiņas id
    public abstract void changeChildByIdGroupById(int childId, int groupId, Child temp);
}
