package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStrStack {

  private StrStack strStack;
  
  @BeforeEach
  public void setUp() {
    // To create a new StrStack instance (really a stack) before each test is executed
    
    strStack = new StrStack();
  }
  
  @Test   // CONTINUE EDITING FROM HERE
  void testStackSize() { 
    //Test that the newly created stack returns the expected value of 0 items
    assertEquals(strStack.size(), 0, "Test that the newly created stack returns the expected size of 0 items");   
    
  }
  
  @Test 
  // Test that push method works by checking size is updated accordingly, size should be 1.
  void testPush() {
    
    strStack.push("Sample String"); 
    assertEquals(strStack.size(), 1); 
  }

  @Test // Test to check that pop() method pops the expected string values from stack.
  void testPop() {
    
    strStack.push("Sample String");
    assertEquals(strStack.size(), 1);
    
    strStack.push("Sample String One");
    assertEquals(strStack.size(), 2);
    
    strStack.push("Sample String Two");
    assertEquals(strStack.size(), 3);
    
    assertEquals(strStack.pop(), "Sample String Two");
    assertEquals(strStack.pop(), "Sample String One");
    assertEquals(strStack.pop(), "Sample String");
    
  }
 
  
  @Test // Test to check that top() method returns a string value without updating stack - CHECK LATER 
  void testTop() {
    
    strStack.push("Sample String");  
    strStack.push("Sample String One");
    strStack.push("Sample String Two"); 
    
    assertEquals(strStack.top(), "Sample String Two");    
    
    strStack.pop();
    assertEquals(strStack.top(), "Sample String One"); 
    
     
    strStack.pop();
    assertEquals(strStack.top(), "Sample String"); 
    
  }
  
  @Test // Test to check that isEmpty() method return the correct boolean value when a new stack is created. 
  void testIsEmpty() {
    assertTrue(strStack.isEmpty());
    
    strStack.push("Sample String");
    assertFalse(strStack.isEmpty());
    
    strStack.pop();
    assertTrue(strStack.isEmpty());
    
  }  

  
  
  
  
  
}



