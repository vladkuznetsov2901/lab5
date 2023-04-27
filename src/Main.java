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

    }


}