package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestSymbol {

  @Test // Test 1
  void testToString() {
 
    // To test that each symbol is associated with the right descriptor
    
    Symbol symbol = Symbol.RIGHT_BRACKET;
    assertTrue(symbol.toString().equals(")"));

    Symbol symbol1 = Symbol.LEFT_BRACKET;
    assertTrue(symbol1.toString().equals("("));

    Symbol symbol2 = Symbol.TIMES;
    assertTrue(symbol2.toString().equals("*"));

    Symbol symbol3 = Symbol.DIVIDE;
    assertTrue(symbol3.toString().equals("/"));

    Symbol symbol4 = Symbol.PLUS;
    assertTrue(symbol4.toString().equals("+"));

    Symbol symbol5 = Symbol.MINUS;
    assertTrue(symbol5.toString().equals("-"));

    Symbol symbol6 = Symbol.INVALID;
    assertTrue(symbol6.toString().equals("N/A"));

  }
}
