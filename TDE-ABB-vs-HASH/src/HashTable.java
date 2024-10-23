import java.util.LinkedList;

class HashTable {
    private int BUCKETS;
    private LinkedList<Integer>[] table;


    public HashTable(int size) {
        BUCKETS = size;
        table = new LinkedList[BUCKETS];
        for (int i = 0; i < BUCKETS; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % BUCKETS;
    }

    public void insert(int key) {
        int bucket = hash(key);
        if (!table[bucket].contains(key)) {
            table[bucket].add(key);
        }
    }

    public Integer search(int key) {
        int bucket = hash(key);
        for (Integer element : table[bucket]) {
            if (element == key) {
                return element;
            }
        }
        return null;
    }

}