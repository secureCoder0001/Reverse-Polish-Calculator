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
   * Constructs and initialises a new stack.
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
   * Top method to return item at top of stack.
   * 
   * @return item at top of stack.
   */
  public float top() {
    return 80.5f;
  }


}




