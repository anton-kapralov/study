package kae.study.codingchallenges.datastructures;

public class ListNode {
  private int val;
  private ListNode next;

  ListNode(int x) {
    val = x;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public int val() {
    return val;
  }

  public void setVal(int val) {
    this.val = val;
  }

  public ListNode next() {
    return next;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return String.valueOf(val);
  }

  public static void print(ListNode head) {
    while (head != null) {
      System.out.print(head.val);
      if (head.next != null) {
        System.out.print(" -> ");
      }
      head = head.next;
    }
  }
}
