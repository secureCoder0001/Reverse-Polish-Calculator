package application;
import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestStack {

  private EntryStack stack;

  @BeforeEach // Run this method to create a new Stack before each test is run
  public void setUp() {

    stack = new EntryStack();
  }
  
  @Test // Test 1
  void testSize() {
    // To make code pass, I simply created an empty stack class.
    // Refactored to work with push.
    assertEquals(stack.size(), 0, "Test that new stack with size 0 indeed returns 0");
  }
  
  @Test // Test 2
  void testPush() {

    stack.push(new Entry(2.5f));
    assertEquals(stack.size(), 1);
  }
  
  
  @Test //Test 3 - to further test size
  void testPushTwoValues() {
    
    // To make code pass initially, I had the push() and pop() methods 
    // increment and decrement a variable called size so as to fake the
    // the output
    
    stack.push(new Entry(5.5f));
    assertEquals(stack.size(), 1);
    stack.push(new Entry(7.5f));
    assertEquals(stack.size(), 2);
  }
  
  
  @Test // Test 4 - testing if size variable changes with size of stack.
  void testPushThreeValues() {
    
    // To make code pass, no further code was needed.
    
    stack.push(new Entry("New String Entry"));
    assertEquals(stack.size(), 1);

    stack.push(new Entry("New String Entry"));
    assertEquals(stack.size(), 2);

    stack.push(new Entry(Symbol.PLUS));
    assertNotEquals(stack.size(), 2,
        "Test that the size indeed changes when an item is added to the stack");
    assertEquals(stack.size(), 3, "Test that the size relflects the actual size of the stack");
  }

  
  @Test // Test 5 - To test that the stack can support an non-finite amount of entries
  void testPushDozens() {

    // Made test case pass by utilizing a fixed sized array.
    
    for (int i = 0; i < 1000; i++) {
      stack.push(new Entry(Symbol.PLUS));
    }

    assertEquals(stack.size(), 1000);
  }
  
  
  @Test // Test 6 - tests that an exception is indeed thrown when you pop() a stack with no items
  void testEmptyPop() {
    
    assertThrows(EmptyStackException.class, () -> stack.pop(),
        "pop() operation on an empty stack is not possible");
  }
  
  
  @Test // Test 7
  void pushThenPop() throws BadTypeException {

    // Tests that a push and a subsequent pop() returns the same item and the size of stack is as
    // expected
    
    // To make test pass, sure the fixed sized array I had would work, but a dynamic data 
    // such as an ArrayList was much more efficient, and so I refactored the code to make use of that
    
    stack.push(new Entry(Symbol.PLUS));

    assertEquals(stack.pop().getSymbol(), Symbol.PLUS,
        "Pushing a plush symbol and subsequently popping it should return PLUS");
    assertEquals(stack.size(), 0,
        "Pushing a value onto the stack and subsequently popping it should give an empty stack");
  } 
  
  
  
  @Test // Test 8 - tests order of popping is correct
  void pushThriceThenPop() throws BadTypeException {

    // Tests pushing three times and the popping 3 times should give you the items in the right
    // order.

    
    // To make test pass, nothing was needed as I was already removing the last indexed item
    // which is equivalent to the top of the stack
    
    stack.push(new Entry("New String1"));
    stack.push(new Entry(10.5f));
    stack.push(new Entry(Symbol.PLUS));

    assertEquals(stack.pop().getSymbol(), Symbol.PLUS,
        "PLUS is on the top of the stack and so the corresponding operator ('+')should be returned by this method");
    assertEquals(stack.pop().getValue(), 10.5f,
        "10.5 is the second to last item pushed and so popping twice should return the 10.5");
    assertEquals(stack.pop().getString(), "New String1",
        " 'New String1' is the first item pushed and so should be last item returned when popping thrice");

    assertEquals(stack.size(), 0,
        "Pushing 3 times and subsequently popping 3 times should give an empty stack");

    assertThrows(EmptyStackException.class, () -> stack.pop(),
        "Stack is empty and so EmptyStackException should be thrown");
  }  
  
  
  
  @Test // Test 9
  void testTop() throws BadTypeException {

    // Tests that top always returns the top item in the stack, even when items are removed

    stack.push(new Entry(Symbol.LEFT_BRACKET));
    stack.push(new Entry("Test String"));
    stack.push(new Entry(3.5f));

    assertEquals(stack.top().getValue(), 3.5f,
        "The item at the top of the stack should be returned, 3.5");
    stack.pop();
    assertEquals(stack.top().getString(), "Test String",
        "The item at the top of the stack should be returned, \"Test String\" ");
    stack.pop();
    assertEquals(stack.top().getSymbol(), Symbol.LEFT_BRACKET,
        "The item at the top of the stack should be returned, '('");
  }
   
  
  @Test // Test 10
  void testTopOnEmtpyStack() {

    // Tests that calling the top() method on a empty stack does indeed throw an exception

    assertThrows(EmptyStackException.class, () -> stack.top());
  }  
  
  
  @Test // Test 11
  void testTopNotRemove() throws BadTypeException {

    stack.push(new Entry(10.5f));
    stack.top();

    assertEquals(stack.top().getValue(), 10.5f, "Stack should have an item in it");
  }
}
