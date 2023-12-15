package application;


/**
 * A facade for stack to hide implementation details of stack for ease of use of floats. 
 * 
 * @author Mohamed Mohamed 
 *
 */
public class NumStack {

  private EntryStack stack;
  
  /**
   * Constructs and initialises a new NumStack.
   * 
   */
  public NumStack() {
    
    this.stack = new EntryStack();
  }
  
  /**
  * Returns the size of the NumStack.
  * 
  * @return the size of the stack.
  */
  public int size() {
    
    return this.stack.size();
  }
  
  /**
   * Pushes a float onto the top of a NumStack instance.
   * 
   * @param number float to be pushed onto the stack.
   */
  public void push(float number) { 
    
    this.stack.push(new Entry(number));
  }

  
  /**
   * Top method to return item at top of stack (without removing it).
   * 
   * @return item at top of stack.
   */
  public float top() {
    
    try {
      return this.stack.top().getValue();
    } catch (BadTypeException e) {
      System.err.println();
    }
    
    return -1;    
  }
  
  /**
   * Method to return a float from the NumStack (if it exitsts) and remove it from said NumStack.
   * 
   * @return item popped from NumStack instance.
   */
  public float pop() {
    
    try {
      return this.stack.pop().getValue();
    } catch (BadTypeException e) {
      System.err.println(); 
    }
    return -1;
  }
  
  /**
   * Check if NumStack instance is empty. If so, return true, false otherwise.
   * 
   * @return boolean value indicating whether or not NumStack is empty.
   */
  public boolean isEmpty() {
    
    return this.stack.size() == 0;
  }
  
}
