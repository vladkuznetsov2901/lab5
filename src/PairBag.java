public class PairBag {

    private Object[] items;

    private int maxSize;

    public PairBag(int maxSize) {
        items = new Object[maxSize];
        maxSize = this.maxSize;
    }


    public void add(Pair<?, ?> item) {
        // добавление элемента в случайную позицию
        int index = (int)Math.round(Math.random()*(maxSize));
        if (index == maxSize) {
            items[maxSize++] = item;
        } else {
            // сдвигаем элементы на одну позицию вправо, начиная с последнего
            for (int i = maxSize; i > index; i--) {
                items[i] = items[i-1];
            }
            items[index] = item;
            maxSize++;
        }
    }

    public Object remove() {
        // удаление элемента из случайной позиции и его возвращение
        if (maxSize == 0) {
            return null;
        }
        int index = (int)Math.round(Math.random()*(maxSize - 1));
        Pair<?, ?> item = (Pair<?, ?>) items[index];
        for (int i = index; i < maxSize-1; i++) {
            items[i] = items[i+1];
        }
        items[--maxSize] = null;
        return item;
    }


    public void size() {
        System.out.println(items.length);
    }

    public void printPairBag(){
        for (int i = 0; i < maxSize; i++){
            Pair<?, ?> item = (Pair<?, ?>) items[i];
            System.out.println("First: " + item.getFirst() + " Second: " + item.getSecond());
        }

    }
}
