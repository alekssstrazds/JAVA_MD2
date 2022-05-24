package lv.venta.demo.services;

import java.util.ArrayList;

import lv.venta.demo.model.Child;

public interface IChildService {
    //atgriež visus bērnus, kas ir grupiņā, ja ir zināms grupiņas id
    public abstract ArrayList<Child> selectAllChildInGroupByGroupId(int id) throws Exception;
    //izdzēš bērnu no grupiņas, ja ir zināms grupiņas id un bērna id
    public abstract void deleteChildByIdFromGroupById(int groupId, int childId) throws Exception;
    //pievieno jaunu bērnu sistēmā un to pievieno grupiņai, ja ir zināms grupiņas id
    public abstract Child insertNewChild(int id, Child temp);
    // nomaina esošā bērna grupiņu uz jaunu, ja ir zināms jaunās grupiņas id
    public abstract void changeChildByIdGroupById(int childId, int groupId) throws Exception;
}
