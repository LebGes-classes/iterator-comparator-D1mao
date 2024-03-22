package MyHashMap;

public class Node<K, V> implements Comparable<Node<K, V>>{
    int hash;
    K key;
    V value;
    Node<K, V> next;

    Node(int hash, K key, V value, Node<K, V> next){
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public int checkValue(){
        if(this.value instanceof Integer){
            return 0;
        } else if (this.value instanceof String) {
            return 1;
        }
        return 2;
    }

    @Override
    public int compareTo(Node<K, V> o) {
        int vType = this.checkValue();
        switch (vType){
            case 0:
                if ((Integer)this.value > (Integer) o.value){
                    return 1;
                } else if ((Integer)this.value < (Integer) o.value) {
                    return -1;
                } else {
                    return 0;
                }
            case 1:
                if (this.value.equals(o.value)){
                    return 0;
                } else {
                    return -1;
                }
        }
        System.out.println("Я такое не сравниваю");
        return -2;
    }
}
