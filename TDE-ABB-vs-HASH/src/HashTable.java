import java.util.*;

class HashTable {
    private int BUCKETS;
    private LinkedList<Integer>[] table;

    @SuppressWarnings("unchecked")
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

    public boolean search(int key) {
        int bucket = hash(key);
        return table[bucket].contains(key);
    }
}
