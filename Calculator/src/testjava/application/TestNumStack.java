package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;

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
  void testPush(){
    // Test that push method works by checking size is updated accordingly, size should be 1.    
    numStack.push(3.5f);
    assertEquals(numStack.size(), 1); 
  }
  

  @Test // Test to check that top() method returns a number without updating stack - CHECK LATER
  void testTop() {
    
    numStack.push(80.5f);  
    assertEquals(numStack.top(), 80.5f);
  }
  
  @Test
  void testPop() {
    
    numStack.push(90.5f);
    assertEquals(numStack.pop(), 90.5f);
  }
  
}