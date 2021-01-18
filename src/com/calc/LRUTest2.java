package com.calc;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2021/1/16
 */
public class LRUTest2 {

  class LRUCache2<K, V> {

    private int capacity;
    private HashMap<K, Node<K, V>> map;
    private Node<K, V> head;
    private Node<K, V> tail;

//    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public LRUCache2(int capacity) {
      this.capacity = capacity;
      this.map = new HashMap<>(capacity);

    }

    private void addNode(Node node) {
      if(head == null){
        head = tail = node;
      }else{
        head.prev = node;
        node.next = head;
        head = node;
      }
    }

    private void moveToHead(Node node) {
      if (node == head) {
        return;
      }

      if (node == tail) {
        node.prev.next = null;

        node.prev = null;
        node.next = head;
        head = node;
        return;
      }

      node.prev.next = node.next;
      node.next.prev = node.prev;

      node.prev = null;
      node.next = head;
      head = node;
    }

    private void removeTail() {
      if (tail == null) {
        return;
      }

      if (tail.prev != null) {
        tail.prev.next = null;
      }

      tail = tail.prev;
    }


    public void put(K key, V value) {
      if (map.containsKey(key)) {
        Node node = map.get(key);
        node.value = value;
        moveToHead(node);

      } else {
        Node node = new Node(key, value);
        addNode(node);

        map.put(key,node);
        if(map.size() >=capacity){
            removeTail();
        }
      }
    }
  }


  class Node<K, V> {

    Node prev;
    Node next;
    K key;
    V value;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }


}
