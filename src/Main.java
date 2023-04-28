import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Pair<Integer, String> pair1 = new Pair<>(0, "ervwevwe");

        pair1.printPair();



        Bag bag1 = new Bag(10);
        bag1.add(5);
        bag1.add("brtyybtytn");
        bag1.add(7.2);
        System.out.println("Size of bag1: " + bag1.size());
        System.out.println("Random item from bag1: " + bag1.get());
        System.out.println("Removed item from bag1: " + bag1.remove());
        System.out.println("Size of bag1: " + bag1.size());

        PairBag pairBag1 = new PairBag(10);

        pairBag1.add(pair1);

        pairBag1.size();

        pairBag1.printPairBag();

        GPairBag<String> gPairBag1 = new GPairBag<String>(10);

        gPairBag1.add(pair1);

        gPairBag1.getAll();

        GenericPairBag<String> genericPairBag1 = new GenericPairBag<String>();

        genericPairBag1.add(pair1);

        genericPairBag1.printGenericPairBag();

        DList<Integer, Integer> dList1 = new DList<>();





        HashFunction<String> hashFunction = new StringHashFunction(10);
        HashTable<String, Person> hashTable = new HashTable<String, Person>(10, hashFunction);
        Person p1 = new Person("1", "John Doe", 25);
        Person p2 = new Person("2", "Jane Smith", 30);
        Person p3 = new Person("3", "Bob Johnson", 40);
        hashTable.insert(p1);
        hashTable.insert(p2);
        hashTable.insert(p3);
        Person p = hashTable.search("3");
        if (p != null) {
            System.out.println("Found person: " + p.getName());
        } else {
            System.out.println("Person not found.");
        }
        hashTable.delete("1");

        while (true) {
            System.out.println("Enter 1 to add a new value and sublist");
            System.out.println("Enter 2 to remove a value and its sublist");
            System.out.println("Enter 3 to display the list");
            System.out.println("Enter 4 to exit");
            Scanner scanner = new Scanner(System.in);
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
                    dList1.add(value, subList);
                    System.out.println("Added value: " + value + " and sublist: " + subList);
                    break;

                case 2:
                    System.out.println("Enter a value to remove: ");
                    int valueToRemove = scanner.nextInt();
                    dList1.remove(valueToRemove);
                    System.out.println("Removed value: " + valueToRemove);
                    break;

                case 3:
                    System.out.println("Списки связанные с заданными целыми числами:");
                    for (int i = 0; i < dList1.getList1().size(); i++) {
                        System.out.println(dList1.getList1().get(i) + ": " + dList1.getList2().get(i));
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