import java.util.ArrayList;

interface HashFunction<K> {
    int hash(K s);
}

class HashTable<K, T extends KeyedItem<K>> {
    private int size;
    private ArrayList<ArrayList<T>> table;
    private HashFunction<K> hashFunction;

    public HashTable(int size, HashFunction<K> hashFunction) {
        this.size = size;
        this.hashFunction = hashFunction;
        table = new ArrayList<ArrayList<T>>();
        for (int i = 0; i < size; i++) {
            table.add(new ArrayList<T>());
        }
    }

    public void insert(T item) {
        int index = hashFunction.hash(item.getKey()) % size;
        table.get(index).add(item);
    }

    public T search(K key) {
        int index = hashFunction.hash(key) % size;
        ArrayList<T> list = table.get(index);
        for (T item : list) {
            if (item.getKey().equals(key)) {
                return item;
            }
        }
        return null;
    }

    public void delete(K key) {
        int index = hashFunction.hash(key) % size;
        ArrayList<T> list = table.get(index);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                list.remove(i);
                break;
            }
        }
    }
}

interface KeyedItem<K> {
    K getKey();
    void setKey(K key);
    boolean contains(K value);
}

class Person implements KeyedItem<String> {
    private String key;
    private String name;
    private int age;

    public Person(String key, String name, int age) {
        this.key = key;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean contains(String value) {
        return name.contains(value);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

class StringHashFunction implements HashFunction<String> {
    private int size;

    public StringHashFunction(int size) {
        this.size = size;
    }

    public int hash(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (31 * hash + s.charAt(i)) % size;
        }
        return hash;
    }
}

class Main2 {
    public static void main(String[] args) {
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
