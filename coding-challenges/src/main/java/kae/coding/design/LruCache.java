package kae.coding.design;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/** */
public class LruCache {

  private static class Node {
    private final int key;
    private int value;
    private Node previous;
    private Node next;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", "[", "]")
          .add(key + " : " + value)
          .add("p=" + (previous == null ? "null" : previous.key))
          .add("n=" + (next == null ? "null" : next.key))
          .toString();
    }
  }

  private Node head;
  private Node tail;
  private final Map<Integer, Node> map;
  private final int capacity;

  private final Object lock = new Object();

  public LruCache(int capacity) {
    map = new HashMap<>(capacity);
    this.capacity = capacity;
  }

  public int get(int key) {
    synchronized (lock) {
      Node node = map.get(key);
      if (node != null) {
        moveToHead(node);
        return node.value;
      } else {
        return -1;
      }
    }
  }

  public void put(int key, int value) {
    synchronized (lock) {
      Node node = map.get(key);
      if (node == null) {
        ensureCapacity();
        node = newNode(key, value);
        map.put(key, node);
      } else {
        node.value = value;
        moveToHead(node);
      }
    }
  }

  private void ensureCapacity() {
    if (map.size() < capacity) {
      return;
    }
    removeFromTail().ifPresent(node -> map.remove(node.key));
  }

  private void moveToHead(Node node) {
    if (node == null) {
      return;
    }

    Node previous = node.previous;
    if (previous == null) {
      return;
    }

    Node next = node.next;

    previous.next = next;

    if (next != null) {
      next.previous = previous;
    } else {
      tail = previous;
    }

    head.previous = node;
    node.next = head;
    node.previous = null;
    head = node;

    System.out.println("moveToHead");
    printList();
  }

  private Node newNode(int key, int value) {
    Node node = new Node(key, value);

    node.next = head;

    if (head != null) {
      head.previous = node;
    }

    head = node;

    if (tail == null) {
      tail = node;
    }

    System.out.println("newNode");
    printList();

    return node;
  }

  private java.util.Optional<Node> removeFromTail() {
    if (tail == null) {
      return java.util.Optional.empty();
    }

    Node oldTail = tail;

    if (tail.previous == null) {
      head = null;
      tail = null;
    } else {
      tail.previous.next = null;
      tail = tail.previous;
    }

    System.out.println("removeFromTail");
    printList();

    return java.util.Optional.of(oldTail);
  }

  private void printList() {
    Node node = head;

    while (node != null) {
      System.out.printf("%d -> ", node.key);
      node = node.next;
    }
    System.out.println("null");
  }
}
