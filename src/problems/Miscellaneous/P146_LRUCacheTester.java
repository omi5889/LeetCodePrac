package problems.Miscellaneous;

import java.util.HashMap;

/**
 * Created by omkar on 4/10/19.
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 it should invalidate the least recently used item before inserting a new item.


 *
 * Example:

 LRUCache cache = new LRUCache( 2  ); // 2 is capacity

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 *
 *
 * Solution
 * https://www.geeksforgeeks.org/design-a-data-structure-for-lru-cache/
 *
 */

class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    private HashMap<Integer,Node> map;
    private Node head,tail;
    private int capacity, count;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
    }

    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public int get(int key) {
        if(map.get(key)!= null) {
            Node node = map.get(key);
            int result = node .val;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }

    public void set(int key, int value) {
        if(map.get(key)!=null) {
            Node node = map.get(key);
            node.val = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key,value);
            map.put(key,node);
            if(count<capacity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
    }

}

public class P146_LRUCacheTester {
    public static void main(String[] args){

        P146_LRUCacheTester obj = new P146_LRUCacheTester();
        LRUCache cache = new LRUCache(2);
        cache.set(1, 10);
        cache.set(2, 20);
        System.out.println("Value for the key: 1 is " + cache.get(1));
        cache.set(3, 30);
        System.out.println("Value for the key: 2 is " + cache.get(2));
        cache.set(4, 40);
        System.out.println("Value for the key: 1 is " + cache.get(1));
        System.out.println("Value for the key: 3 is " + cache.get(3));
        System.out.println("Value for the key: 4 is " + cache.get(4));
    }
}
