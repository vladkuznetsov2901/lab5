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


    public static void main(String[] args) {
        DList<Integer, Integer> dList = new DList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 1 to add a new value and sublist");
            System.out.println("Enter 2 to remove a value and its sublist");
            System.out.println("Enter 3 to display the list");
            System.out.println("Enter 4 to exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter a value: ");
                    int value = scanner.nextInt();
                    System.out.println("Enter a sublist of integers separated by spaces:");
                    List<Integer> subList = new ArrayList<>();
                    String input = scanner.nextLine();
                    input = scanner.nextLine();
                    String[] elements = input.split(" ");
                    for (String element : elements) {
                        subList.add(Integer.parseInt(element));
                    }
                    dList.add(value, subList);
                    System.out.println("Added value: " + value + " and sublist: " + subList);
                    break;

                case 2:
                    System.out.println("Enter a value to remove: ");
                    int valueToRemove = scanner.nextInt();
                    dList.remove(valueToRemove);
                    System.out.println("Removed value: " + valueToRemove);
                    break;

                case 3:
                    System.out.println("Списки связанные с заданными целыми числами:");
                    for (int i = 0; i < dList.list1.size(); i++) {
                        System.out.println(dList.list1.get(i) + ": " + dList.list2.get(i));
                    }
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }


}