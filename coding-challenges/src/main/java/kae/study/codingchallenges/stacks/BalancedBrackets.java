package kae.study.codingchallenges.stacks;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

  public static boolean isBalanced(String expression) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < expression.length(); ++i) {
      char bracket = expression.charAt(i);
      if (bracket == '{' || bracket == '(' || bracket == '[') {
        stack.push(bracket);
      } else {
        if (stack.size() == 0) {
          return false;
        }

        char top = stack.pop();
        if (top == '{' && bracket == '}'
            || top == '(' && bracket == ')'
            || top == '[' && bracket == ']') {
          continue;
        } else {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      String expression = in.next();
      System.out.println((isBalanced(expression)) ? "YES" : "NO");
    }
  }
}
