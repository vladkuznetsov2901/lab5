import java.util.ArrayList;
import java.util.List;

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

        List<Integer> subList = new ArrayList<>();

        subList.add(3);

        dList1.add(2, subList);



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

    }


}