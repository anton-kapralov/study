package kae.study.codingchallenges.java.strings.validnumber;

/** */
class Solution {

  public boolean isNumber(String s) {
    return new Parser(s).parse();
  }
}

class Parser {

  private final char[] input;
  private char c;
  private int position = -1;
  private boolean error;

  Parser(String s) {
    input = s.toCharArray();
  }

  boolean parse() {
    next();
    whitespace();
    decimalNumber();
    whitespace();
    expect(Symbol.TERMINAL);
    return !error;
  }

  private void next() {
    if (position + 1 >= input.length) {
      c = 0;
      return;
    }

    c = input[++position];
  }

  private void error() {
    error = true;
  }

  private boolean accept(Symbol symbol) {
    if (symbol.is(c)) {
      next();
      return true;
    }

    return false;
  }

  private boolean expect(Symbol symbol) {
    if (accept(symbol)) {
      return true;
    }

    error();
    return false;
  }

  private void decimalNumber() {
    accept(Symbol.SIGN);

    if (accept(Symbol.DIGIT)) {
      integer();

      if (accept(Symbol.DECIMAL_POINT)) {
        integer();
      }

      if (accept(Symbol.EXPONENT)) {
        exponentPower();
      }
    } else if (expect(Symbol.DECIMAL_POINT)) {
      if (accept(Symbol.DIGIT)) {
        integer();
        if (accept(Symbol.EXPONENT)) {
          exponentPower();
        }
      } else {
        error();
      }
    } else {
      error();
    }
  }

  private void exponentPower() {
    accept(Symbol.SIGN);
    if (!expect(Symbol.DIGIT)) {
      return;
    }
    integer();
  }

  private void integer() {
    //noinspection StatementWithEmptyBody
    while (accept(Symbol.DIGIT)) {}
  }

  private void whitespace() {
    //noinspection StatementWithEmptyBody
    while (accept(Symbol.WHITESPACE)) {}
  }

  private enum Symbol {
    TERMINAL() {
      @Override
      boolean is(char c) {
        return c == 0;
      }
    },
    WHITESPACE() {
      boolean is(char c) {
        return c == ' ';
      }
    },
    SIGN {
      @Override
      boolean is(char c) {
        return c == '-' || c == '+';
      }
    },
    DIGIT {
      @Override
      boolean is(char c) {
        return c >= '0' && c <= '9';
      }
    },
    DECIMAL_POINT {
      @Override
      boolean is(char c) {
        return c == '.';
      }
    },
    EXPONENT {
      @Override
      boolean is(char c) {
        return c == 'e';
      }
    };

    abstract boolean is(char c);
  }
}
