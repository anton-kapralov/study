package kae.study.codingchallenges.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Node<T> {

  private final T value;

  private final List<Node<T>> linkedNodes;

  public Node(T value) {
    this.value = value;
    this.linkedNodes = new LinkedList<>();
  }

  public Node(T value, List<Node<T>> linkedNodes) {
    this.value = value;
    this.linkedNodes = linkedNodes;
  }

  public T getValue() {
    return value;
  }

  public List<Node<T>> getLinkedNodes() {
    return linkedNodes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Node)) return false;
    Node<?> node = (Node<?>) o;
    return Objects.equals(value, node.value) &&
        Objects.equals(linkedNodes, node.linkedNodes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, linkedNodes.size());
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
