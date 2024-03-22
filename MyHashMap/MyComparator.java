package MyHashMap;

public class MyComparator<K, V> {
    public int compare(Node<K, V> e1, Node<K, V> e2) {
        return e1.compareTo(e2);
    }
}