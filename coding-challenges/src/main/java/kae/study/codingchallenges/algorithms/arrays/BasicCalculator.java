package kae.study.codingchallenges.algorithms.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

interface Token {
  boolean isOperator();
}

abstract class Operator implements Token, Comparable<Operator> {

  @Override
  public final boolean isOperator() {
    return true;
  }

  abstract int calculate(int a, int b);

  protected abstract int getRank();

  @Override
  public int compareTo(Operator o) {
    return getRank() - o.getRank();
  }

  static Operator valueOf(char c) {
    switch (c) {
      case '+':
        return new PlusOperator();
      case '-':
        return new MinusOperator();
      case '*':
        return new MultiplyOperator();
      case '/':
        return new DivideOperator();
      default:
        throw new IllegalArgumentException(String.valueOf(c));
    }
  }
}

class PlusOperator extends Operator {

  private static final int rank = 0;

  @Override
  int calculate(int a, int b) {
    return a + b;
  }

  @Override
  protected int getRank() {
    return 0;
  }

  @Override
  public String toString() {
    return "+";
  }
}

class MinusOperator extends Operator {

  private static final int rank = 0;

  @Override
  int calculate(int a, int b) {
    return a - b;
  }

  @Override
  protected int getRank() {
    return rank;
  }

  @Override
  public String toString() {
    return "-";
  }
}

class MultiplyOperator extends Operator {

  private static final int rank = 1;

  @Override
  int calculate(int a, int b) {
    return a * b;
  }

  @Override
  protected int getRank() {
    return rank;
  }

  @Override
  public String toString() {
    return "*";
  }
}

class DivideOperator extends Operator {

  private static final int rank = 1;

  @Override
  int calculate(int a, int b) {
    return a / b;
  }

  @Override
  protected int getRank() {
    return rank;
  }

  @Override
  public String toString() {
    return "/";
  }
}

class Number implements Token {

  private final int value;

  private Number(int value) {
    this.value = value;
  }

  @Override
  public boolean isOperator() {
    return false;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  static Number valueOf(String s) {
    return new Number(Integer.parseInt(s));
  }
}

class Parser {

  private int pos;
  private final String expression;

  Parser(String expression) {
    this.expression = expression;
  }

  Token nextToken() {
    char c = nextCharacter();

    while (c == ' ') {
      c = nextCharacter();
    }

    if (Character.isDigit(c)) {
      StringBuilder sb = new StringBuilder();
      while (Character.isDigit(c)) {
        sb.append(c);

        c = nextCharacter();
      }

      if (c != 0) {
        --pos;
      }

      return Number.valueOf(sb.toString());
    }


    return c != 0 ? Operator.valueOf(c) : null;
  }

  private char nextCharacter() {
    return pos < expression.length() ? expression.charAt(pos++) : 0;
  }

}

/** */
public class BasicCalculator {

  public static void main(String[] args) {
    BasicCalculator calculator = new BasicCalculator();
    System.out.println(calculator.calculate("3+2*2"));
    System.out.println(calculator.calculate("3+5 / 2"));
  }

  public int calculate(String s) {
    Deque<Token> tokenQueue = createReversePolishNotation(s);

    return calculate(tokenQueue);
  }

  private int calculate(Deque<Token> tokenQueue) {
    Deque<Integer> calculationStack = new ArrayDeque<>();
    while (!tokenQueue.isEmpty()) {
      Token token = tokenQueue.pollFirst();
      if (!token.isOperator()) {
        calculationStack.addFirst(((Number) token).getValue());
      } else {
        Operator operator = (Operator) token;
        int b = calculationStack.pop();
        int a = calculationStack.pop();
        calculationStack.push(operator.calculate(a, b));
      }
    }

    return calculationStack.pop();
  }

  private Deque<Token> createReversePolishNotation(String s) {
    Deque<Token> outputQueue = new ArrayDeque<>();
    Deque<Operator> operatorsStack = new ArrayDeque<>();

    Parser p = new Parser(s);

    Token token;
    while (null != (token = p.nextToken())) {
      if (token.isOperator()) {
        Operator operator = (Operator) token;
        while (!operatorsStack.isEmpty() && operator.compareTo(operatorsStack.peek()) <= 0) {
          outputQueue.addLast(operatorsStack.pop());
        }
        operatorsStack.addFirst(operator);
      } else {
        outputQueue.addLast(token);
      }
    }

    while (!operatorsStack.isEmpty()) {
      outputQueue.addLast(operatorsStack.pop());
    }

    return outputQueue;
  }
}
