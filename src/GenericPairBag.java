import java.util.ArrayList;

public class GenericPairBag<T> {
    private ArrayList<Pair<?, ?>> pairs;

    public GenericPairBag() {
        pairs = new ArrayList<>();
    }

    public void add(Pair<?, ?> pair) {
        pairs.add(pair);
    }

    public void printGenericPairBag(){
        for (Pair<?, ?> pair : pairs) {
            System.out.println(pair);
        }
    }


    public int size() {
        return pairs.size();
    }
}
