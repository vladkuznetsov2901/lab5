import java.util.ArrayList;
import java.util.List;

public class GPairBag<T> extends PairBag {
    public GPairBag(int maxSize) {
        super(10);
    }

    private static class Node {
        Pair<?, ?> pair;
        Node next;

        public Node(Pair<?, ?> pair) {
            this.pair = pair;
            this.next = null;
        }
    }

    private Node head;



    public void add(Pair<?, ?> pair) {
        Node newNode = new Node(pair);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void remove(Pair<T, T> pair) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.pair.equals(pair)) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public boolean contains(Pair<T, T> pair) {
        Node current = head;

        while (current != null) {
            if (current.pair.equals(pair)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public List<Pair<T, T>> getAll() {
        List<Pair<T, T>> pairs = new ArrayList<>();
        Node current = head;

        while (current != null) {
            pairs.add((Pair<T, T>) current.pair);
            current = current.next;
        }

        for (int i = 0; i < pairs.size(); ++i){
            Pair<?, ?> pair = pairs.get(i);
            System.out.println("First: " + pair.getFirst() + " Second: " + pair.getSecond());
        }


        return pairs;
    }
}
