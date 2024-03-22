package MyHashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class MyHashMap<K, V> implements MyIterator<Node<K, V>, K>{
    private final List<Node<K, V>> nodes;
    private Node<K, V> currentNode;
    private int currentIndex;

    MyHashMap(){
        int CAPACITY = 16;
        nodes = new ArrayList<>(CAPACITY);
        for (int i = 0; i < CAPACITY; i ++){
            nodes.add(null);
        }
    }

    public V put(K key, V value){
        int hash = key.hashCode();
        int index = Math.abs(hash % nodes.size());
        Node<K, V> current = nodes.get(index);
        while (current != null){
            if (current.key.equals(key)){
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
            current = current.next;
        }
        Node<K, V> newNode = new Node<K, V>(hash, key, value, nodes.get(index));
        nodes.set(index, newNode);
        return null;
    }
    public V getValue(K key){
        int hash = key.hashCode();
        int index = Math.abs(hash % nodes.size());

        Node<K, V> current = nodes.get(index);
        while (current != null){
            if (current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public Node<K, V> getNode(K key){
        int hash = key.hashCode();
        int index = Math.abs(hash % nodes.size());

        Node<K, V> current = nodes.get(index);
        while (current != null){
            if (current.key.equals(key)){
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean containsKey(K key){
        int hash = key.hashCode();
        int index = Math.abs(hash % nodes.size());
        Node<K, V> current = nodes.get(index);
        while (current != null){
            if (current.key.equals(key)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean containsValue(V value){
        for (Node<K, V> node : nodes){
            Node<K, V> current = node;
            while (current != null){
                if (current.value.equals(value)){
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        while (currentNode == null && currentIndex < nodes.size() - 1) {
            currentIndex++;
            currentNode = nodes.get(currentIndex);
        }
        return currentNode != null;
    }

    @Override
    public Node<K, V> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        currentNode = currentNode.next;
        return currentNode;
    }

    public void remove(K key){
        int hash = key.hashCode();
        int index = Math.abs(hash % nodes.size());
        Node<K, V> current = nodes.get(index);
        Node<K, V> prev = null;

        while (current != null){
            if (current.key.equals(key)){
                if (prev == null){
                    nodes.set(index, current.next);
                } else {
                    prev.next =current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public int size() {
        int size = 0;
        for (Node<K, V> node : nodes) {
            Node<K, V> current = node;
            while (current != null) {
                size++;
                current = current.next;
            }
        }
        return size;
    }
}
