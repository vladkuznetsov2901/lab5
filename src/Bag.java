import java.util.Arrays;

public class Bag {
    private Object[] items; // массив элементов
    private int size; // текущий размер мешка

    public Bag(int capacity) {
        items = new Object[capacity];
        size = 0;
    }

    public void add(Object item) {
        // добавление элемента в случайную позицию
        int index = (int)Math.round(Math.random()*(size));
        if (index == size) {
            items[size++] = item;
        } else {
            // сдвигаем элементы на одну позицию вправо, начиная с последнего
            for (int i = size; i > index; i--) {
                items[i] = items[i-1];
            }
            items[index] = item;
            size++;
        }
    }

    public Object remove() {
        // удаление элемента из случайной позиции и его возвращение
        if (size == 0) {
            return null;
        }
        int index = (int)Math.round(Math.random()*(size-1));
        Object item = items[index];
        for (int i = index; i < size-1; i++) {
            items[i] = items[i+1];
        }
        items[--size] = null;
        return item;
    }

    public Object get() {
        // получение случайного элемента
        if (size == 0) {
            return null;
        }
        int index = (int)Math.round(Math.random()*(size-1));
        return items[index];
    }

    public int size() {
        // текущий размер мешка
        return size;
    }

    // запрещаем переопределение методов Object
    @Override
    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public final int hashCode() {
        return super.hashCode();
    }

    @Override
    public final String toString() {
        return super.toString();
    }
}
