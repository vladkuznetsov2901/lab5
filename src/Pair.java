public class Pair<T1,T2> {
    T1 first;
    T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }


    public T1 getFirst() {
        return first;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    public T2 getSecond() {
        return second;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }

    public static <T1, T2> Pair<T1, T2> makePair(T1 first, T2 second) {
        return new Pair<>(first, second);
    }



    public void printPair(  ){
        System.out.println("id = " + first + ", value = " + second);
    }
}
