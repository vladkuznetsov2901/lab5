import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class DList<T1,T2> {
    private List<T1> list1 = new ArrayList<>();
    private List<T2> list2 = new ArrayList<>();


    public List<T1> getList1() {
        return list1;
    }

    ;

    public List<T2> getList2() {
        return list2;
    };

    public void add(T1 value, List<T2> subList) {
        int index = list1.indexOf(value);
        if (index == -1) {
            list1.add(value);
            List<List<T2>> subLists = new ArrayList<>();
            subLists.add(subList);
            list2.add((T2) subLists);
        } else {
            List<List<T2>> subLists = (List<List<T2>>) list2.get(index);
            subLists.add(subList);
        }
    };


    public List<List<T2>> getSubLists(T1 value) {
        int index = list1.indexOf(value);
        if (index == -1) {
            return new ArrayList<>();
        }
        return (List<List<T2>>) list2.get(index);
    }

    ;

    public boolean remove(T1 value) {
        int index = list1.indexOf(value);
        if (index == -1) {
            return false;
        }
        list1.remove(index);
        list2.remove(index);
        return true;
    }

    ;

    public boolean remove(int index) {
        if (index < 0 || index >= list1.size()) {
            return false;
        }
        list1.remove(index);
        list2.remove(index);
        return true;
    }



}