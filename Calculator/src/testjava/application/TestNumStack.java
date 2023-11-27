package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNumStack {

  private NumStack numStack; 
  
  @BeforeEach
  public void setUp() {
    // To create a new NumStack (really, a stack) before each test is executed
    
    numStack = new NumStack();
  }
  
  @Test
  void testStackSize() {
    //Test that the newly created stack returns the expected of 0 items
    assertEquals(numStack.size(), 0, "Test that the newly created stack returns the expected size of 0 items");   
    
  }
  
  @Test
  void testPush() {
    // Test that push method of numStack pushes floats to the stack and updates NumStack size
    // accordingly
    
    numStack.push(3.5f);
    assertEquals(numStack.size(), 1); 
    
  }
  
  @Test
  void testPushThreeValue() {
    // Further testing the push() method by pushing three floats onto NumStack.
    
    numStack.push(5.6f);
    assertEquals(numStack.size(), 1);

    numStack.push(3.5f);
    assertEquals(numStack.size(), 2);

    numStack.push(10.5f);  
    assertNotEquals(numStack.size(), 2,
        "Test that the size indeed changes when an item is added to the stack");
    assertEquals(numStack.size(), 3, "Test that the size expected relflects the actual size of the stack");
  } 
    
  @Test
  void pushMillions() {
    // Pushing a few million numbers onto numStack and checking if expected size reflects actuals size;
    
    for (int i = 0; i < 6000000; i++) {
      numStack.push((float) i);
    }

    assertEquals(numStack.size(), 6000000); 
  }

  

}