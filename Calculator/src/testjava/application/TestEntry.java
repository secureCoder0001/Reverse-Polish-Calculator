package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestEntry {
 
  @Test // Test 1

  // Tests that the constructor creates a number entry

  void testCreateNumberEntry() {

    Entry number = new Entry(2.5f);
  }

  @Test // Test 2
  void testCreateStringEntry() {

    // Tests that the constructor creates a string entry

    Entry strEntry = new Entry("String Entry");
  }

  @Test // Test 4
  void testCreateSymbolEntry() {

    // Tests that the constructor creates a symbol entry

    Entry symbolEntry = new Entry(Symbol.RIGHT_BRACKET);
  }

  @Test // Test 5 - tests getter
  void testGetNumValue() throws BadTypeException {

    Entry number = new Entry(9.5f);

    assertEquals(number.getValue(), 9.5f,
        "No value should be returned as no fields have been created yet");
  }

  @Test // Test 6 - tests getter
  void testGetStringValue() throws BadTypeException {

    Entry string = new Entry("String Entry");

    assertTrue(string.getString().equals("String Entry"),
        "Entry object should return a string equal to \"Entry String\"");
  }

  @Test // Test 7
  void testCreateString() throws BadTypeException {

    Entry symbol = new Entry(Symbol.RIGHT_BRACKET);

    assertTrue(symbol.getSymbol() == Symbol.RIGHT_BRACKET, "Testing Symbol");
  }


  @Test // Test 8 - testing that getValue() throws an exception for different types
  void testGetNumber() {

    Entry string = new Entry("2.5");

    // Just testing the getValue will return any value, which it shouldn't. If so, throw an
    // exception
    assertThrows(BadTypeException.class, () -> string.getValue(),
        "BadTypeException: Exception occurred calling getValue() using a string Entry");

  }

  @Test // Test 9 - Furthermore, checking if getString() will respond to appropriate types and
        // handle exceptions
  void testGetString() {

    Entry number = new Entry(10.5f);

    // Just testing the getString() will return a value, which it shouldn't. If so, throw an
    // exception
    assertThrows(BadTypeException.class, () -> number.getString(),
        "BadTypeException: Exception occurred calling getString() using a float Entry");

  }

  @Test // Test 10 - Testing Symbol getter throws appropriate exception for different entry types
  void testGetSymbol() {

    Entry string = new Entry("String");

    // testing the getSymbol() method will return a value, which it shouldn't. If so, throw an
    // exception
    assertThrows(BadTypeException.class, () -> string.getSymbol(),
        "BadTypeException: Exception occurred calling getSymbol() using a string Entry");

    Entry number = new Entry(2.5f);

    assertThrows(BadTypeException.class, () -> number.getSymbol(),
        "BadTypeException: Exception occurred calling getSymbol() using a string Entry");

  }

  @Test // Test 11
  void testGetType() {

    // Tests that the type field of an Entry corresponds to the type of the value

    Entry string = new Entry("New String");
    assertEquals(string.getType(), Type.STRING);

    Entry number = new Entry(100.5f);
    assertEquals(number.getType(), Type.NUMBER);

    Entry symbol = new Entry(Symbol.RIGHT_BRACKET);
    assertEquals(symbol.getType(), Type.SYMBOL);
  }

  @Test // Test 12
  void testEntriesAreEquals() {

    // First to test that two String entries are equal
    Entry stringEntry = new Entry("New String");
    Entry stringEntry1 = new Entry("New String");
    assertTrue(stringEntry.equals(stringEntry1));

    Entry floatEntry = new Entry(10.5f);
    assertFalse(stringEntry.equals(floatEntry));


    // To test that two float entries are equal
    Entry floatEntry1 = new Entry(3.5f);
    Entry floatEntry2 = new Entry(3.5f);
    assertTrue(floatEntry1.equals(floatEntry2));

    Entry symbolEntry = new Entry(Symbol.LEFT_BRACKET);
    assertFalse(floatEntry1.equals(symbolEntry));


    // To test that two symbol entries are equal
    Entry symbolEntry1 = new Entry(Symbol.PLUS);
    Entry symbolEntry2 = new Entry(Symbol.PLUS);
    assertTrue(symbolEntry1.equals(symbolEntry2));

    Entry stringEntry3 = new Entry("String to be tested against");
    assertFalse(symbolEntry1.equals(stringEntry3));

  }

}
