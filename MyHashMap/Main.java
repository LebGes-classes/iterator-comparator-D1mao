package MyHashMap;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> hashmap = new MyHashMap<String, Integer>();
        MyComparator<String, Integer> comparator = new MyComparator<String, Integer>();

        hashmap.put("Ключ", 1);
        hashmap.put("Ключище", 2);
        hashmap.put("Ключевский", 3);

        System.out.println("Размер: " + hashmap.size());
        System.out.println("Ключ: " + hashmap.getValue("Ключ"));
        System.out.println("Ключище: " + hashmap.getValue("Ключище"));
        System.out.println("Ключевский: " + hashmap.getValue("Ключевский"));

        System.out.println("Содержит ключ 'Ключище': " + hashmap.containsKey("Ключище"));
        System.out.println("Содержит значение 3: " + hashmap.containsValue(3));

        hashmap.remove("Ключевский");
        System.out.println("Удаляем ключ 'Ключевский");
        System.out.println("Размер после удаления: " + hashmap.size());

        System.out.println("Сравним Ключ и Ключище: " + comparator.compare(hashmap.getNode("Ключ"), hashmap.getNode("Ключище")));

        while (hashmap.hasNext()){
            System.out.println(hashmap.next().value);
        }
    }
}