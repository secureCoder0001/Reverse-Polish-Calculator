package application;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOpStack {
   
  private OpStack opStack; 
  
  @BeforeEach
  public void setUp() {
    // To create a new OpStack (really, a stack) before each test is executed
    
    opStack = new OpStack();
  }
  
  @Test
  void testStackSize() {
    //Test that the newly created stack returns the expected value of 0 items
    assertEquals(opStack.size(), 0, "Test that the newly created stack returns the expected size of 0 items");   
    
  }
  
  @Test 
  // Test that push method works by checking size is updated accordingly, size should be 1.
  void testPush() {
    
    opStack.push(Symbol.RIGHT_BRACKET);
    assertEquals(opStack.size(), 1); 
  }
  
  
  @Test // Test to check that pop() method pops the expected symbols from stack.
  void testPop() {
    
    opStack.push(Symbol.RIGHT_BRACKET);
    assertEquals(opStack.size(), 1);
    
    opStack.push(Symbol.PLUS);
    assertEquals(opStack.size(), 2);
    
    opStack.push(Symbol.TIMES);
    assertEquals(opStack.size(), 3);
    
    assertEquals(opStack.pop(), Symbol.TIMES);
    assertEquals(opStack.pop(), Symbol.PLUS);
    assertEquals(opStack.pop(), Symbol.RIGHT_BRACKET);
    
  }
  
  
  @Test // Test to check that top() method returns a symbol without updating stack
  void testTop() {
    
    opStack.push(Symbol.DIVIDE);  
    opStack.push(Symbol.MINUS);
    opStack.push(Symbol.RIGHT_BRACKET); 
    
    assertEquals(opStack.top(), Symbol.RIGHT_BRACKET);    
    
    opStack.pop();
    assertEquals(opStack.top(), Symbol.MINUS); 
    
     
    opStack.pop();
    assertEquals(opStack.top(), Symbol.DIVIDE); 
    
  }
  
  
  
  @Test // Test to check that isEmpty() method returns the correct boolean value when a new stack is created.
  void testIsEmpty() { 
    assertTrue(opStack.isEmpty());
    
    opStack.push(Symbol.PLUS);
    assertFalse(opStack.isEmpty());
    
    opStack.pop();
    assertTrue(opStack.isEmpty());
    
  }
  

}
