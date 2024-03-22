package MyHashMap;

public interface MyIterator<E, K> {
    boolean hasNext();
    E next();
    void remove(K key);
}
